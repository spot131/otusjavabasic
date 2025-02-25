package ru.otus.java.basic.homeworks.projectwork.commands;

import java.nio.file.Path;

public interface Command {
    void execute(String[] args);
}