package ru.capchik.samsungandroid2021.iep0621.l211206;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Threads {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RED = "\u001B[31m";

    private static AtomicLong atomicOperationsCount = new AtomicLong();
    private static long operationsCount;

    private static final Object mathLockObject = new Object();

    private static final Object printLockObject = new Object();

    static int count = 0;
    static int[] counts = new int[2];
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> longWorkWithNoLock(1, 10, counts, 0));
        Thread thread2 = new Thread(() -> longWorkWithNoLock(10, 20, counts, 1));
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();

        System.out.println("done " + (counts[0] + counts[1]));
    }

    private static void longWorkWithNoLock(long startItem, long endItem, int[] target, int index) {
        double sum = 0;
        for (long i = startItem; i < endItem; i++) {
            int temp = target[index] + 1;
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            target[index] = temp;
            sum += i * i / Math.sqrt(i);
        }
        System.out.println("--- " + sum);
    }


    private static void workWithPrints() throws InterruptedException {
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(50);
                    printLogMessage("HeyRed", 31);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();
        for (int i = 0; i < 20; i++) {
            Thread.sleep(50);
            printLogMessage("from main", 30);
        }
    }

    private synchronized static void printLogMessage(String message, int colorCode) throws InterruptedException {
        System.out.print("\u001B[" + colorCode + "m");
        System.out.print(message);
        Thread.sleep(20);
        System.out.println(ANSI_RESET);
    }

    private static void workWithMathInThreads() throws InterruptedException {
        long start = System.currentTimeMillis();

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println(cores);

        List<Thread> threads = createThreads(4);
        for (Thread thread : threads) {
            thread.start();
        }
        while (!isEnd(threads)) {
            System.out.println("waiting: " + operationsCount + " | " + atomicOperationsCount.get());
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000 + "s result: " + operationsCount);
        System.out.println((end - start) / 1000 + "s atomic result: " + atomicOperationsCount.get());
    }

    private static boolean isEnd(List<Thread> threads) {
        for (Thread thread : threads) {
            if (thread.isAlive()) {
                return false;
            }
        }
        return true;
    }

    private static List<Thread> createThreads(int count) {
        long startItem = 1;
        long endItem = 10_000_000_000l / 8 / 4;
        long part = endItem / count;
        ArrayList<Thread> workers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Thread thread = createWorker(i, startItem + part * i, startItem + part * (i + 1));
            workers.add(thread);
        }
        return workers;
    }

    private static Thread createWorker(int workerNum, long startItem, long endItem) {
        Thread thread = new Thread(() -> longWork(startItem, endItem));
        thread.setDaemon(false);
        thread.setName("worker #" + workerNum);
        return thread;
    }


    private static void longWork(long startItem, long endItem) {
        System.out.println(Thread.currentThread().getName() + " from " + startItem + " to " + endItem + " started");
        long start = System.currentTimeMillis();
        double sum = 0;
        for (long i = startItem; i < endItem; i++) {
            sum += i * i / Math.sqrt(i);
            synchronized (mathLockObject) {
                operationsCount++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + " " + sum + " done in " + (end - start) / 1000);
    }

    private static void longWorkWithAtomic(long startItem, long endItem) {
        System.out.println(Thread.currentThread().getName() + " from " + startItem + " to " + endItem + " started");
        long start = System.currentTimeMillis();
        double sum = 0;
        for (long i = startItem; i < endItem; i++) {
            sum += i * i / Math.sqrt(i);

            long temp = operationsCount + 1;
            operationsCount = temp;

            operationsCount++;

            atomicOperationsCount.incrementAndGet();
        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + " " + sum + " done in " + (end - start) / 1000);
    }

    private static void showTwoPrints() {
        Thread thr = new Thread(() -> printNumbers(10));
        thr.start();
        printNumbers(10);
    }

    private static void printNumbers(int sleep) {
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(sleep);
                System.out.println(Thread.currentThread().getId() + ": " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void workWithColoredConsole() {
        System.out.println(ANSI_BLUE + "row1\n" + ANSI_RESET + "row2\t" + ANSI_RED + "row3\nro4");
    }
}
