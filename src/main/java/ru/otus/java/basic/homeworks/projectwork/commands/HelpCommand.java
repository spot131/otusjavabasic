package ru.otus.java.basic.homeworks.projectwork.commands;

import java.util.Map;

public class HelpCommand implements Command {
    private final Map<String, Command> commands;

    public HelpCommand(Map<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Available commands:");
        for (String cmd : commands.keySet()) {
            System.out.println("  " + cmd);
        }
    }
}
