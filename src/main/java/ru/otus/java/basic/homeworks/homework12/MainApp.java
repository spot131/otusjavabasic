package ru.otus.java.basic.homeworks.homework12;
import java.io.*;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Доступные текстовые файлы:");
        File rootDir = new File(".");
        File[] files = rootDir.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("нет текстовых файлов в корневой директории");
            return;
        }

        for (int i = 0; i < files.length; i++) {
            System.out.println((i + 1) + ". " + files[i].getName());
        }

        System.out.print("Введите номер файла, с которым будем работать: ");
        int fileChoice;
        try {
            fileChoice = Integer.parseInt(scanner.nextLine());
            if (fileChoice < 1 || fileChoice > files.length) {
                System.out.println("Некорретный номер. Завершение работы...");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Некорретный ввод. Завершение работы...");
            return;
        }

        File selectedFile = files[fileChoice - 1];
        System.out.println("Вы выбрали: " + selectedFile.getName());


        System.out.println("\nСодержимое файла:");
        try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            return;
        }

        System.out.println("\nТеперь будем записывать строки в файл. ДЛя завершение введите exit");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile, true))) {
            while (true) {
                System.out.print("ВВедите строку для записи: ");
                String input = scanner.nextLine();
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
                writer.write(input);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }

        System.out.println("Изменения сохранены. Завершение работы...");
    }
}
