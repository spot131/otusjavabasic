package ru.otus.java.basic.homeworks.homework2;

import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {
        printLine(5, "Hello");
        sumGreaterThenFive(new int[]{0, 7, 7, 7});
        fillArray(5, new int[]{0,7,7,7,7,7,7,7,7,7});
        enlargeArray (1, new int[]{0,7,7,7,7,7,7,7,7,7});
    }

    public static void printLine(int n,String lineForPrint){
        for (int i = 0; i < n; i++) {
            System.out.println(lineForPrint);
        }
    }


    public static void sumGreaterThenFive(int[] array){
        int sum =0;
        for (int j : array) {
            if (j > 5) {
                sum += j;
            }
        }
        System.out.println(sum);
    }

    public static void fillArray(int n, int[] array){
        for (int i = 0; i < array.length; i++) {
           array[i] = n;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void enlargeArray (int n, int[] array){
        for (int i = 0; i < array.length ; i++) {
            array[i]+=n;
        }
        System.out.println(Arrays.toString(array));
    }

}