package ru.otus.java.basic.homeworks.projectwork.commands;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class CpCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: cp [source] [destination]");
            return;
        }

        Path currentDir = Paths.get(System.getProperty("user.dir"));
        Path source = currentDir.resolve(args[0]).normalize();
        Path destination = currentDir.resolve(args[1]).normalize();

        if (!Files.exists(source)) {
            System.out.println("Error: Source file '" + args[0] + "' does not exist.");
            return;
        }

        if (Files.isDirectory(source)) {
            System.out.println("Error: Cannot copy a directory. Use a recursive copy method if needed.");
            return;
        }

        if (Files.isDirectory(destination)) {
            destination = destination.resolve(source.getFileName());
        }

        try {
            if (!Files.exists(destination)) {
                Files.createFile(destination);
            }
        } catch (IOException e) {
            System.out.println("Error creating destination file: " + e.getMessage());
            return;
        }

        if (Files.exists(destination)) {
            System.out.print("Warning: '" + destination.getFileName() + "' already exists. Overwrite? (y/n): ");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("y")) {
                System.out.println("Copy operation canceled.");
                return;
            }
        }

        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Copied '" + args[0] + "' to '" + args[1] + "'");
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }
}
