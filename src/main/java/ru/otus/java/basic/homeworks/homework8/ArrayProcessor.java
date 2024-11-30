package ru.otus.java.basic.homeworks.homework8;

public class ArrayProcessor {
    public static int processArray(String[][] array) throws AppArraySizeException, AppArrayDataException {
        // Check if the array is 4x4
        if (array.length != 4) {
            throw new AppArraySizeException("Массив должен иметь 4 строки. Сейчас: " + array.length);
        }
        for (String[] row : array) {
            if (row.length != 4) {
                throw new AppArraySizeException("Каждая строка должка иметь 4 столбца");
            }
        }

        int sum = 0;
        // Process the array elements
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(
                            "Неверные данные в ячейке [" + i + "][" + j + "]: \"" + array[i][j] + "\""
                    );
                }
            }
        }
        return sum;
    }
}