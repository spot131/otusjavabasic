package ru.otus.java.basic.homeworks.projectwork.commands;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class LsCommand implements Command {
    // ANSI escape codes for colors
    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";  // Blue for files
    private static final String GREEN = "\u001B[32m"; // Green for directories

    @Override
    public void execute(String[] args) {
        Path currentDir = Paths.get(System.getProperty("user.dir"));
        Path targetDir = currentDir;

        // Check if a relative directory path is provided
        if (args.length > 0 && !args[0].equals("-i")) {
            targetDir = currentDir.resolve(args[0]).normalize();
            if (!Files.isDirectory(targetDir)) {
                System.out.println("Error: '" + args[0] + "' is not a directory.");
                return;
            }
        }

        boolean detailed = args.length > 0 && args[args.length - 1].equals("-i");

        try (Stream<Path> stream = Files.list(targetDir)) {
            stream.forEach(path -> {
                String color = Files.isDirectory(path) ? GREEN : BLUE; // Assign color
                String output = color + path.getFileName() + RESET;

                if (detailed) {
                    try {
                        BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                        output += String.format("  %10d bytes %s", attrs.size(), attrs.lastModifiedTime());
                    } catch (IOException e) {
                        System.err.println("Error reading file attributes: " + e.getMessage());
                    }
                }

                System.out.println(output);
            });
        } catch (IOException e) {
            System.err.println("Error listing files: " + e.getMessage());
        }
    }
}
