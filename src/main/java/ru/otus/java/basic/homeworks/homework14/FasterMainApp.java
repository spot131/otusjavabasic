package ru.otus.java.basic.homeworks.homework14;

public class FasterMainApp {
    public static void main(String[] args) {
        double[] array = new double[100_000_000];
        int numThreads = 4;
        Thread[] threads = new Thread[numThreads];
        long startTime = System.nanoTime();
        int chunkSize = array.length / numThreads;

        for (int threadIndex = 0; threadIndex < numThreads; threadIndex++) {
            final int start = threadIndex * chunkSize;
            final int end = (threadIndex == numThreads - 1) ? array.length : start + chunkSize;

            threads[threadIndex] = new Thread(() -> {
                for (int i = start; i < end; i++) {
                    array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                }
            });
            threads[threadIndex].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Поток прерван: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }

        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime) / 1_000_000;
        System.out.println("Время, затраченное на вычисление в 4 потока: " + elapsedTime + " ms");

    }
}
