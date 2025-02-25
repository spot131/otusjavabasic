package ru.otus.java.basic.homeworks.projectwork.commands;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CdCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: cd [directory]");
            return;
        }

        Path currentDir = Paths.get(System.getProperty("user.dir"));
        Path targetDir = currentDir.resolve(args[0]).normalize();

        // Handle special case: "cd .." (Go to parent directory)
        if (args[0].equals("..")) {
            targetDir = currentDir.getParent();
        }

        if (targetDir == null || !Files.isDirectory(targetDir)) {
            System.out.println("Error: '" + args[0] + "' is not a valid directory.");
            return;
        }

        System.setProperty("user.dir", targetDir.toAbsolutePath().toString());
        System.out.println("Current directory: " + System.getProperty("user.dir"));
    }
}
