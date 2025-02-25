package ru.otus.java.basic.homeworks.projectwork.commands;


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FindCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: find [filename]");
            return;
        }

        String targetFile = args[0];
        Path currentDir = Paths.get(System.getProperty("user.dir"));

        try {
            Files.walkFileTree(currentDir, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    if (file.getFileName().toString().equals(targetFile)) {
                        System.out.println("Found: " + file.toAbsolutePath());
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            System.err.println("Error searching for file: " + e.getMessage());
        }
    }
}
