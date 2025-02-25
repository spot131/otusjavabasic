package ru.otus.java.basic.homeworks.projectwork.commands;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class MvCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: mv [source] [destination]");
            return;
        }

        Path currentDir = Paths.get(System.getProperty("user.dir"));
        Path source = currentDir.resolve(args[0]).normalize();
        Path destination = currentDir.resolve(args[1]).normalize();

        if (!Files.exists(source)) {
            System.out.println("Error: Source file/directory '" + args[0] + "' does not exist.");
            return;
        }

        // If destination is an existing directory, move the file into it
        if (Files.isDirectory(destination)) {
            destination = destination.resolve(source.getFileName());
        }

        // Check if destination exists and warn the user
        if (Files.exists(destination)) {
            System.out.print("Warning: '" + destination.getFileName() + "' already exists. Overwrite? (y/n): ");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("y")) {
                System.out.println("Move operation canceled.");
                return;
            }
        }

        try {
            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Moved '" + args[0] + "' to '" + args[1] + "'");
        } catch (IOException e) {
            System.out.println("Error moving file: " + e.getMessage());
        }
    }
}

