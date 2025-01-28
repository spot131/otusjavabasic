package ru.otus.java.basic.homeworks.homework13;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            String operations = in.readLine();
            System.out.println(operations);

            while (true) {
                System.out.print("Ведите первое число (или 'exit' для выхода): ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    out.println("exit");
                    System.out.println("Клиент завершил работу");
                    break;
                }

                double num1 = Double.parseDouble(input);
                System.out.print("Введите второе число: ");
                double num2 = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Введите действие: сложить (a), вычесть (s), умножить (m), разделить (d): ");
                String operation = scanner.nextLine();

                out.println(num1);
                out.println(num2);
                out.println(operation);

                String result = in.readLine();
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
