package ru.otus.java.basic.homeworks.projectwork;

import ru.otus.java.basic.homeworks.projectwork.commands.*;
import java.util.HashMap;
import java.util.Map;

public class CommandProcessor {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandProcessor() {
        commands.put("ls", new LsCommand());
        commands.put("cd", new CdCommand());
        commands.put("mkdir", new MkdirCommand());
        commands.put("rm", new RmCommand());
        commands.put("mv", new MvCommand());
        commands.put("cp", new CpCommand());
        commands.put("finfo", new FinfoCommand());
        commands.put("find", new FindCommand());
        commands.put("pwd", new PwdCommand());
        commands.put("help", new HelpCommand(commands));
        commands.put("exit", new ExitCommand());
    }

    public void executeCommand(String input) {
        String[] parts = input.split("\\s+");
        String commandName = parts[0];
        String[] args = new String[parts.length - 1];
        System.arraycopy(parts, 1, args, 0, args.length);

        Command command = commands.get(commandName);
        if (command != null) {
            command.execute(args);
        } else {
            System.out.println("Unknown command: " + commandName);
        }
    }
}