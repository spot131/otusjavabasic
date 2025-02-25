package ru.otus.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private int port;
    private List<ClientHandler> clients;

    public Server(int port) {
        this.port = port;
        clients = new CopyOnWriteArrayList<>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту: " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                subscribe(new ClientHandler(socket, this));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        broadcastMessage("Из чата вышел: " + clientHandler.getUsername());
    }

    public void broadcastMessage(String message) {
        for (ClientHandler c : clients) {
            c.sendMsg(message);
        }
    }

    public void sendPrivateMessage(String senderUsername, String recipientUsername, String message) {
        ClientHandler recipient = getClientByUsername(recipientUsername);
        if (recipient != null) {
            recipient.sendMsg("[Private] " + senderUsername + ": " + message);
        } else {
            for (ClientHandler client : clients) {
                if (client.getUsername().equals(senderUsername)) {
                    client.sendMsg("User " + recipientUsername + " not found.");
                }
            }
        }
    }

    public void kickUser(String targetUsername) {
        ClientHandler target = getClientByUsername(targetUsername);
        if (target != null) {
            target.sendMsg("You have been kicked from the chat by an admin.");
            unsubscribe(target);
            target.disconnect();
        } else {
            for (ClientHandler client : clients) {
                client.sendMsg("User " + targetUsername + " not found.");
            }
        }
    }

    private ClientHandler getClientByUsername(String username) {
        for (ClientHandler client : clients) {
            if (client.getUsername().equals(username)) {
                return client;
            }
        }
        return null;
    }
}
