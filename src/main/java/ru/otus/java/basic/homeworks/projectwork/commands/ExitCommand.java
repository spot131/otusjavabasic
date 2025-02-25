package ru.otus.java.basic.homeworks.projectwork.commands;

public class ExitCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Exiting file manager. Goodbye!");
        System.exit(0);
    }
}

