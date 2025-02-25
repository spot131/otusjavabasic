package ru.otus.java.basic.homeworks.projectwork;

import java.util.Scanner;

public class FileManager {
    public static void main(String[] args) {
        CommandProcessor commandProcessor = new CommandProcessor();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            commandProcessor.executeCommand(input);
        }
    }
}