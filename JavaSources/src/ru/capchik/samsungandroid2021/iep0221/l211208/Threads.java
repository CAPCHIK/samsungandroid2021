package ru.capchik.samsungandroid2021.iep0221.l211208;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Threads {

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    static AtomicLong atomicOperationsCount = new AtomicLong();

    public static void main(String[] args) throws InterruptedException {
        int[] results = new int[2];
        Thread thread1 = new Thread(() -> hardWorkNonBlock(0, 500_000_000, results, 0));
        Thread thread2 = new Thread(() -> hardWorkNonBlock(500_000_000, 1_000_000_000, results, 1));
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(results[0] + results[1]);
    }

    static long count;
    private static void hardWorkNonBlock(long startNum, long endNum, int[] counts, int index) {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + " started " + startNum + " - " + endNum);
        long start = System.currentTimeMillis();
        double sum = 0;
        for (long i = startNum; i < endNum; i++) {
            sum += i * i * i - Math.sqrt(i + 1);
            counts[index]++;
        }
        long end = System.currentTimeMillis();
        System.out.println(currentThread.getName() +
                " done in "
                + (end - start) / 1000 + "s. Result: " + sum);
    }

    private static void workWithSynchronizedPrint() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                printLogMessage("from thread", 34);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("trololo");
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            printLogMessage("from main", 31);
        }
    }

    private synchronized static void printLogMessage(String message, int colorCode) {
        try {
            System.out.print("\u001B[" + colorCode + "m");
            Thread.sleep(0);
            System.out.print(message);
            Thread.sleep(0);
            System.out.println(ANSI_RESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void workWithMathInThreads() throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("cores: " + cores);

        long totalNumber = 1_000_000_000L;
        List<Thread> workers = createWorkers(0, totalNumber, cores);
        long start = System.currentTimeMillis();
        for (Thread worker : workers) {
            worker.start();
        }

        while (!isEnd(workers)) {
            long end = System.currentTimeMillis();
            System.out.printf("working %ds %.0f%%\n", (end - start) / 1000,
                    (atomicOperationsCount.get() / (double) totalNumber) * 100);
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("total work: " + (end - start) / 1000 + "s");
        System.out.println(atomicOperationsCount.get());
    }

    private static boolean isEnd(List<Thread> threads) {
        for (Thread t : threads) {
            if (t.isAlive()) {
                return false;
            }
        }
        return true;
    }

    private static List<Thread> createWorkers(long start, long end, int workersCount) {
        ArrayList<Thread> threads = new ArrayList<>();
        long onePart = (end - start) / workersCount;
        for (int i = 0; i < workersCount; i++) {
            long localStart = start + (onePart * i);
            long localEnd = start + (onePart * (i + 1));
            Thread worker = new Thread(() -> hardWork(localStart, localEnd));
            worker.setName("worker #" + i);
            threads.add(worker);
        }
        return threads;
    }

    private static void hardWork(long startNum, long endNum) {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + " started " + startNum + " - " + endNum);
        long start = System.currentTimeMillis();
        double sum = 0;
        for (long i = startNum; i < endNum; i++) {
            sum += i * i * i - Math.sqrt(i + 1);
            atomicOperationsCount.incrementAndGet();
        }
        long end = System.currentTimeMillis();
        System.out.println(currentThread.getName() +
                " done in "
                + (end - start) / 1000 + "s. Result: " + sum);
    }

    private static void workWithOneWorker() {
        Thread thread = new Thread(() -> printNumbers(0));
        thread.setName("worker");
        thread.setDaemon(false);
        thread.start();
        printNumbers(0);
        System.out.println("done");
    }

    private static void printNumbers(int delay) {
        try {
            Thread currentThread = Thread.currentThread();
            for (int i = 0; i < 10; i++) {
                System.out.println(currentThread.getName() + ": " + i);
                Thread.sleep(delay);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void workWithAnsi() {
        System.out.println("Hello\nwo\u001B[34mrld");
        System.out.println("hello!!\u001B[0m!!))))0)))");
    }
}
