package ru.otus.java.basic.homeworks.homework17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CharSequenceCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        System.out.print("Enter the character sequence to count: ");
        String targetSequence = scanner.nextLine();

        try {
            int count = countOccurrences(fileName, targetSequence);
            System.out.println("The sequence \"" + targetSequence + "\" appears " + count + " times in the file.");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static int countOccurrences(String fileName, String targetSequence) throws IOException {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) {
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            String fileContent = content.toString();

            int index = 0;
            while ((index = fileContent.indexOf(targetSequence, index)) != -1) {
                count++;
                index += targetSequence.length();
            }
        }

        return count;
    }
}