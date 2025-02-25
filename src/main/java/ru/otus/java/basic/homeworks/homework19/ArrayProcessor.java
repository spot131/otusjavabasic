package ru.otus.java.basic.homeworks.homework19;

public class ArrayProcessor {

    /**
     * Returns a new array containing elements after the last occurrence of 1.
     *
     * @param array The input array to process
     * @return A new array with elements after the last 1
     * @throws RuntimeException if the input array doesn't contain any 1's
     */
    public static int[] getElementsAfterLastOne(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        int lastOneIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                lastOneIndex = i;
            }
        }

        if (lastOneIndex == -1) {
            throw new RuntimeException("Input array doesn't contain any 1's");
        }

        int resultLength = array.length - lastOneIndex - 1;
        int[] result = new int[resultLength];

        for (int i = 0; i < resultLength; i++) {
            result[i] = array[lastOneIndex + 1 + i];
        }

        return result;
    }

    /**
     * Checks if the array contains only 1's and 2's, with at least one of each.
     *
     * @param array The input array to check
     * @return true if the array contains only 1's and 2's with at least one of each, false otherwise
     */
    public static boolean containsOnlyOnesAndTwos(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }

        boolean hasOne = false;
        boolean hasTwo = false;

        for (int num : array) {
            if (num == 1) {
                hasOne = true;
            } else if (num == 2) {
                hasTwo = true;
            } else {
                return false;
            }
        }

        return hasOne && hasTwo;
    }
}
