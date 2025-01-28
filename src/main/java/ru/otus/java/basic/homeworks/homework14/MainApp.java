package ru.otus.java.basic.homeworks.homework14;

public class MainApp {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        double[] array = new double[100_000_000];

        for (int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }

        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime) / 1_000_000;
        System.out.println("Время, затраченное на вычисление: " + elapsedTime + " ms");
    }
}
