package ru.otus.java.basic.homeworks.projectwork.commands;


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FinfoCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: finfo [filename]");
            return;
        }

        Path path = Paths.get(args[0]);
        if (!Files.exists(path)) {
            System.out.println("Error: File does not exist.");
            return;
        }

        try {
            BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("File: " + path.getFileName());
            System.out.println("Size: " + attrs.size() + " bytes");
            System.out.println("Last Modified: " + attrs.lastModifiedTime());
            System.out.println("Creation Time: " + attrs.creationTime());
        } catch (IOException e) {
            System.err.println("Error retrieving file information: " + e.getMessage());
        }
    }
}
