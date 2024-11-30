package ru.otus.java.basic.homeworks.homework8;

import static ru.otus.java.basic.homeworks.homework8.ArrayProcessor.processArray;

public class MainApp {
    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "восемь"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            System.out.println("Sum: " + processArray(validArray));
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println("Sum: " + processArray(invalidSizeArray));
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println("Sum: " + processArray(invalidDataArray));
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.err.println(e.getMessage());
        }

    }
}


class AppArraySizeException extends Exception {
    public AppArraySizeException(String message) {
        super(message);
    }
}

class AppArrayDataException extends Exception {
    public AppArrayDataException(String message) {
        super(message);
    }
}

