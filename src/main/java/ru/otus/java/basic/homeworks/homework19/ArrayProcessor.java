package ru.otus.java.basic.homeworks.homework19;

public class ArrayProcessor {

    public static int[] processArray(int[] inputArray) {
        boolean containsOne = false;
        for (int num : inputArray) {
            if (num == 1) {
                containsOne = true;
                break;
            }
        }

        if (!containsOne) {
            throw new RuntimeException("Array does not contain ones");
        }

        // Find index of the last 1
        int lastIndex = -1;
        for (int i = inputArray.length - 1; i >= 0; i--) {
            if (inputArray[i] == 1) {
                lastIndex = i;
                break;
            }
        }

        // If last 1 is found, return the elements after that
        int[] result = new int[inputArray.length - lastIndex - 1];
        System.arraycopy(inputArray, lastIndex + 1, result, 0, result.length);
        return result;
    }

    public static boolean validateArray(int[] inputArray) {
        boolean containsOneOrTwo = false;

        for (int num : inputArray) {
            if (num == 1 || num == 2) {
                containsOneOrTwo = true;
            } else {
                return false;
            }
        }

        return containsOneOrTwo;
    }
}
