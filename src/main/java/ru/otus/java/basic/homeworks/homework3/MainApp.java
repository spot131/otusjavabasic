package ru.otus.java.basic.homeworks.homework3;

import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {
        int[][] someArray = {{1, 3, 37}, {12, 2, 8}, {3, 42, 6}};

        System.out.println(sumOfPositiveElements(someArray));

        printSquare(10);

        zeroDiagonal(someArray);

        System.out.println(findMax(someArray));

        System.out.println(sumSecondLine(someArray));
    }

    public static int sumOfPositiveElements(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    sum += array[i][j];
                }
            }
        }
        return sum;
    }

    public static void printSquare(int size) {
        String[][] array = new String[size][size];

        for (int i = 0; i < array.length; i++) {
            Arrays.fill(array[i], "*");
        }

        for (String[] row : array) {
            for (String element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void zeroDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    array[i][j] = 0;
                }
            }
        }

        for (int[] row : array) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int findMax(int[][] array) {
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    public static int sumSecondLine(int[][] array) {
        int sum = 0;
        int i = 1;

        if (array.length == 1) {
            return -1;
        } else {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }

}