package ru.otus.chat.server;

import java.sql.*;

public class SQLiteAuthenticatedProvider implements AuthenticatedProvider {

    private static final String DB_URL = "jdbc:sqlite:chat_users.db";  // Path to SQLite database
    private Connection connection;

    private static final String CREATE_USERS_TABLE =
            "CREATE TABLE IF NOT EXISTS users (" +
                    "login TEXT PRIMARY KEY, " +
                    "password TEXT NOT NULL, " +
                    "username TEXT NOT NULL, " +
                    "role TEXT NOT NULL" +
                    ")";

    private static final String COUNT_USERS = "SELECT COUNT(*) FROM users";

    private static final String INSERT_USER =
            "INSERT INTO users (login, password, username, role) VALUES (?, ?, ?, ?)";

    private static final String SELECT_USER_BY_CREDENTIALS =
            "SELECT username, role FROM users WHERE login = ? AND password = ?";

    private static final String CHECK_LOGIN_EXISTS =
            "SELECT COUNT(*) FROM users WHERE login = ?";

    private static final String CHECK_USERNAME_EXISTS =
            "SELECT COUNT(*) FROM users WHERE username = ?";

    private static final String GET_ROLE_BY_USERNAME =
            "SELECT role FROM users WHERE username = ?";

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
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(CREATE_USERS_TABLE);

            int userCount = getCount(COUNT_USERS);
            if (userCount == 0) {
                insertUser("admin", "admin_password", "admin_user", "ADMIN");
                insertUser("user1", "user1_password", "User One", "USER");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertUser(String login, String password, String username, String role) {
        try (PreparedStatement stmt = connection.prepareStatement(INSERT_USER)) {
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
        try (ResultSet rs = executeQuery(SELECT_USER_BY_CREDENTIALS, login, password)) {
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
        return getCount(CHECK_LOGIN_EXISTS, login) > 0;
    }

    private boolean isUsernameTaken(String username) throws SQLException {
        return getCount(CHECK_USERNAME_EXISTS, username) > 0;
    }

    public Role getRoleByUsername(String username) {
        try (ResultSet rs = executeQuery(GET_ROLE_BY_USERNAME, username)) {
            if (rs.next()) {
                return rs.getString("role").equals("ADMIN") ? Role.ADMIN : Role.USER;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    private int getCount(String query, String... params) throws SQLException {
        try (ResultSet rs = executeQuery(query, params)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }

    private ResultSet executeQuery(String query, String... params) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            stmt.setString(i + 1, params[i]);
        }
        return stmt.executeQuery();
    }
}
