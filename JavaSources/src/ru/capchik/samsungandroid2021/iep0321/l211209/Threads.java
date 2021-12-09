package ru.capchik.samsungandroid2021.iep0321.l211209;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Threads {
    static long operationsCount = 0;
    final static Object operationsCountLock = new Object();

    static AtomicLong atomicOperationsCount = new AtomicLong();

    final static Object printMessageLock = new Object();

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        int[] counts = new int[2];
        Thread thread1 = new Thread(() -> hardWorkNonBlock(0, 1_000_000_000, counts, 0));
        Thread thread2 = new Thread(() -> hardWorkNonBlock(1_000_000_000, 2_000_000_000, counts, 1));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000);
        System.out.println(counts[0] + counts[1]);
    }

    private static void hardWorkNonBlock(long startNum, long endNum, int[] counts, int index) {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + ": started " +
                startNum + " - " + endNum);
        long start = System.currentTimeMillis();
        double sum = 0;
        for (long i = startNum; i < endNum; i++) {
            sum += i * i * i + Math.sqrt(i + 1);
            counts[index]++;
        }
        long end = System.currentTimeMillis();
        System.out.println(currentThread.getName() +
                ": done in " + (end - start) / 1000 + "s");
    }

    private static void workWithPrintMessage() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                printMessage("thread " + i, 36);
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            printMessage("main " + i, 35);
        }
    }

    private synchronized static void printMessage(String message, int colorCode) {
        try {
            System.out.print("\u001B[" + colorCode + "m");
            Thread.sleep(1);
            System.out.print(message);
            Thread.sleep(1);
            System.out.println("\u001B[0m");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void workWithHardAtomic() throws InterruptedException {
        long start = System.currentTimeMillis();
        long targetNumber = 1_000_000_000L;
        List<Thread> workers = createWorkers(0, targetNumber, 4);
        for (Thread worker : workers) {
            worker.start();
        }
        while (!isEnd(workers)) {
            long end = System.currentTimeMillis();
            System.out.print("working " + (end - start) / 1000 + "s " +
                    atomicOperationsCount.get() / (double) targetNumber * 100 + "%");
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("Done all in " + (end - start) / 1000 + "s");
        System.out.println(atomicOperationsCount.get());
    }

    private static boolean isEnd(List<Thread> threads) {
        for (Thread thread : threads) {
            if (thread.isAlive()) {
                return false;
            }
        }
        return true;
    }

    private static List<Thread> createWorkers(long start, long end, int workersCount) {
        ArrayList<Thread> threads = new ArrayList<>();
        long onePart = (end - start) / workersCount;
        for (int i = 0; i < workersCount; i++) {
            long startNum = start + onePart * i;
            long endNum = start + onePart * (i + 1);
            Thread worker = new Thread(() -> hardWork(startNum, endNum));
            worker.setName("worker #" + i);
            threads.add(worker);
        }

        return threads;
    }


    private static void hardWork(long startNum, long endNum) {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + ": started " +
                startNum + " - " + endNum);
        long start = System.currentTimeMillis();
        double sum = 0;
        for (long i = startNum; i < endNum; i++) {
            sum += i * i * i + Math.sqrt(i + 1);

//            synchronized (operationsCountLock) {
//                long temp = operationsCount + 1;
//                operationsCount = temp;
//            }
            atomicOperationsCount.incrementAndGet();
        }
        long end = System.currentTimeMillis();
        System.out.println(currentThread.getName() +
                ": done in " + (end - start) / 1000 + "s");
    }

    private static void workWithPrintNumbers() {
        Thread thread = new Thread(() -> printNumbers(500));
        thread.setDaemon(true);
        thread.setName("worker");
        thread.start();
        printNumbers(250);
        System.out.println("program end");
    }

    private static void printNumbers(int sleep) {
        try {
            Thread currentThread = Thread.currentThread();
            for (int i = 0; i < 10; i++) {
                System.out.println(currentThread.getName() + ": " + i);
                Thread.sleep(sleep);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void workWithANSI() {
        System.out.println("Hello \n\u001B[31mworld!");
        System.out.println("\u001B[0mSecond Hello \u001B[34mworld!");
    }
}
