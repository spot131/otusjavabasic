package ru.otus.java.basic.homeworks.projectwork.commands;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class RmCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: rm [filename/directory]");
            return;
        }

        Path currentDir = Paths.get(System.getProperty("user.dir"));
        Path targetPath = currentDir.resolve(args[0]).normalize(); // Resolve relative path

        if (!Files.exists(targetPath)) {
            System.out.println("Error: '" + args[0] + "' does not exist.");
            return;
        }

        try {
            if (Files.isDirectory(targetPath)) {
                if (Files.list(targetPath).findAny().isPresent()) { // Check if directory is non-empty
                    System.out.print("Warning: Directory '" + args[0] + "' is not empty. Delete anyway? (y/n): ");
                    Scanner scanner = new Scanner(System.in);
                    String response = scanner.nextLine().trim().toLowerCase();
                    if (!response.equals("y")) {
                        System.out.println("Delete operation canceled.");
                        return;
                    }
                }
                deleteDirectory(targetPath); // Recursively delete directory
            } else {
                Files.delete(targetPath); // Delete file
            }
            System.out.println("Deleted: " + args[0]);
        } catch (IOException e) {
            System.out.println("Error deleting file/directory: " + e.getMessage());
        }
    }

    private void deleteDirectory(Path dir) throws IOException {
        Files.walk(dir)
                .sorted((p1, p2) -> p2.compareTo(p1)) // Reverse order to delete children first
                .forEach(path -> {
                    try {
                        Files.delete(path);
                    } catch (IOException e) {
                        System.out.println("Error deleting: " + path + " - " + e.getMessage());
                    }
                });
    }
}
