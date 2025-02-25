package ru.otus.java.basic.homeworks.projectwork.commands;

import java.io.IOException;
import java.nio.file.*;

public class MkdirCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: mkdir [directory_name]");
            return;
        }

        Path currentDir = Paths.get(System.getProperty("user.dir"));
        Path newDir = currentDir.resolve(args[0]).normalize(); // Resolve relative path

        if (Files.exists(newDir)) {
            System.out.println("Error: Directory '" + args[0] + "' already exists.");
            return;
        }

        try {
            Files.createDirectories(newDir);
            System.out.println("Directory created: " + newDir);
        } catch (IOException e) {
            System.out.println("Error creating directory: " + e.getMessage());
        }
    }
}
