package ru.otus.chat.server;

import java.sql.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SQLiteAuthenticatedProvider implements AuthenticatedProvider {

    private static final String DB_URL = "jdbc:sqlite:chat_users.db";
    private Connection connection;

    public enum Role {
        USER, ADMIN
    }

    public SQLiteAuthenticatedProvider() {
        try {
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("Connected to SQLite database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize() {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users (" +
                    "login TEXT PRIMARY KEY, " +
                    "password TEXT NOT NULL, " +
                    "username TEXT NOT NULL, " +
                    "role TEXT NOT NULL" +
                    ")");
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM users");
            if (rs.next() && rs.getInt(1) == 0) {
                insertUser("admin", "admin", "admin", "ADMIN");
                insertUser("user1", "user1", "user1", "USER");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertUser(String login, String password, String username, String role) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO users (login, password, username, role) VALUES (?, ?, ?, ?)");
            stmt.setString(1, login);
            stmt.setString(2, password);
            stmt.setString(3, username);
            stmt.setString(4, role);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean authenticate(ClientHandler clientHandler, String login, String password) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT username, role FROM users WHERE login = ? AND password = ?");
            stmt.setString(1, login);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                String role = rs.getString("role");

                clientHandler.setUsername(username);
                clientHandler.setRole(role.equals("ADMIN") ? Role.ADMIN : Role.USER);

                clientHandler.sendMsg("/authok " + username);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        clientHandler.sendMsg("Неверный логин/пароль");
        return false;
    }

    @Override
    public boolean registration(ClientHandler clientHandler, String login, String password, String username) {
        try {
            if (isLoginTaken(login) || isUsernameTaken(username)) {
                clientHandler.sendMsg("Логин или имя пользователя уже заняты");
                return false;
            }
            insertUser(login, password, username, "USER");
            clientHandler.setUsername(username);
            clientHandler.setRole(Role.USER);
            clientHandler.sendMsg("/regok " + username);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        clientHandler.sendMsg("Ошибка при регистрации");
        return false;
    }

    private boolean isLoginTaken(String login) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) FROM users WHERE login = ?");
        stmt.setString(1, login);
        ResultSet rs = stmt.executeQuery();
        return rs.getInt(1) > 0;
    }

    private boolean isUsernameTaken(String username) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) FROM users WHERE username = ?");
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        return rs.getInt(1) > 0;
    }

    public Role getRoleByUsername(String username) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT role FROM users WHERE username = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("role").equals("ADMIN") ? Role.ADMIN : Role.USER;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
