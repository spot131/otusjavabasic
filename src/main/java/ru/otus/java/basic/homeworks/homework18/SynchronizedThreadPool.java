package ru.otus.java.basic.homeworks.homework18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SynchronizedThreadPool {
    private static final Semaphore semaphoreA = new Semaphore(1);
    private static final Semaphore semaphoreB = new Semaphore(0);
    private static final Semaphore semaphoreC = new Semaphore(0);
    private static final int ITERATIONS = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new PrintTask('A', semaphoreA, semaphoreB, ITERATIONS));
        executor.submit(new PrintTask('B', semaphoreB, semaphoreC, ITERATIONS));
        executor.submit(new PrintTask('C', semaphoreC, semaphoreA, ITERATIONS));
        executor.shutdown();
    }

    static class PrintTask implements Runnable {
        private final char letter;
        private final Semaphore currentSemaphore;
        private final Semaphore nextSemaphore;
        private final int iterations;

        public PrintTask(char letter, Semaphore currentSemaphore, Semaphore nextSemaphore, int iterations) {
            this.letter = letter;
            this.currentSemaphore = currentSemaphore;
            this.nextSemaphore = nextSemaphore;
            this.iterations = iterations;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < iterations; i++) {
                    currentSemaphore.acquire();
                    System.out.print(letter);
                    nextSemaphore.release();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted: " + e.getMessage());
            }
        }
    }
}