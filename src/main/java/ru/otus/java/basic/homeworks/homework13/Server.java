package ru.otus.java.basic.homeworks.homework13;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Сервер запущен на порту 8080");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Клиент подсоединен");

                    String operations = "Допустимые операции: сложить (a), вычесть (s), умножить (m), разделить (d)";
                    out.println(operations);

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        if (inputLine.equalsIgnoreCase("exit")) {
                            System.out.println("Клиент отсоединился");
                            break;
                        }

                        try {
                            double num1 = Double.parseDouble(inputLine);
                            double num2 = Double.parseDouble(in.readLine());
                            String operation = in.readLine();

                            double result;
                            switch (operation.toLowerCase()) {
                                case "a":
                                    result = num1 + num2;
                                    break;
                                case "s":
                                    result = num1 - num2;
                                    break;
                                case "m":
                                    result = num1 * num2;
                                    break;
                                case "d":
                                    if (num2 == 0) {
                                        out.println("Ошибка: делить на ноль нельзя");
                                        continue;
                                    }
                                    result = num1 / num2;
                                    break;
                                default:
                                    out.println("Ошибка: недопустимая операция");
                                    continue;
                            }

                            out.println("Результат: " + result);
                        } catch (Exception e) {
                            out.println("Ошибка: неверный ввод");
                        }
                    }
                } catch (Exception e) {
                    System.err.println("Ошибка клиента: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
