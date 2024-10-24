package ru.otus.java.basic.homeworks.homework2;

import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {
        printLine(5, "Hello");
        sumGreaterThenFive(new int[]{0, 7, 7, 7});
        fillArray(5, new int[]{0,7,7,7,7,7,7,7,7,7});
        enlargeArray (1, new int[]{0,7,7,7,7,7,7,7,7,7});
        sumElementsTheBiggestPartOfArray(new int[]{0, 1, 1, 1, 1});
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

    public static void sumElementsTheBiggestPartOfArray(int[] array){
        int middle = array.length/2; //при таком делении пополам, первая половина всегда короче второй, имеем это в виду
        int sum1 =0;
        int sum2 =0;

        for (int i = 0; i < middle; i++) {
            sum1+=array[i];
        }
        for (int i = middle; i < array.length ; i++) {
            sum2+=array[i];
        }
        if (sum1 > sum2) {
            System.out.println("part 1 is bigger - " + sum1);
        }
        if (sum1 < sum2)  {
            System.out.println("part 2 is bigger - "+ sum2);
        }
        if (sum1 == sum2)  {
            System.out.println("part 1 and 2 are equal - "+ sum1);
        }
    }


}