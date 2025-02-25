package ru.otus.java.basic.homeworks.projectwork.commands;
import java.nio.file.Paths;

public class PwdCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println(Paths.get(System.getProperty("user.dir")).toAbsolutePath());
    }
}
