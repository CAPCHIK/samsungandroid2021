package ru.capchik.samsungandroid2021.iep0621.l211129;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Files {
    static String pathToCurrentPackageString = "src/ru/capchik/samsungandroid2021/iep0621/l211129";

    public static void main(String[] args) {

        Path pathToCurrentPackage = Paths.get(pathToCurrentPackageString).toAbsolutePath();
        System.out.println(pathToCurrentPackage);
        File srcFile = new File(pathToCurrentPackage.toString(), "image.jpg");
//        File destFile = new File(pathToCurrentPackage.toString(), "image2.jpg");
        File destFile = new File(pathToCurrentPackage.toString(), "fromstdin.txt");
        System.out.println(srcFile);
        if (!srcFile.exists() || !srcFile.isFile()) {
            System.out.println("incorrect file " + srcFile);
            return;
        }
        try (
                // Close input stream with Ctrl+D
                InputStream inStream = System.in;
                OutputStream outStream = new FileOutputStream(destFile)
        ) {
            byte[] buffer = new byte[1024];
            int read;
            while ((read = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void workWithTextFiles() {
        Path pathToCurrentPackage = Paths.get(pathToCurrentPackageString).toAbsolutePath();
        System.out.println(pathToCurrentPackage);
        File fileInfo = new File(pathToCurrentPackage.toString(), "random2.txt");
        System.out.println(fileInfo);
        if (!fileInfo.exists() || !fileInfo.isFile()) {
            System.out.println("incorrect file " + fileInfo);
            return;
        }
        System.out.println("#1");
        try (FileReader fileReader = new FileReader(fileInfo)) {
            char[] symbols = new char[13];
            int total = 0;
            int readed;
            while ((readed = fileReader.read(symbols)) != -1) {
                total += readed;
                // System.out.print(new String(symbols, 0, readed));
            }
            System.out.println(total);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("#2");
        try(Scanner sc = new Scanner(new FileInputStream(fileInfo))) {
            System.out.println(sc.nextLine().length());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("#3");
        try {
            List<String> lines = java.nio.file.Files.readAllLines(fileInfo.toPath());
            for (String line: lines) {
                System.out.println(line.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void workWithDirs(File fileInfo) {
        System.out.println(fileInfo);
        if (fileInfo.isDirectory()) {
            String[] list = fileInfo.list();
            for (String el : list) {
                System.out.println(el);
            }
            File[] listFiles = fileInfo.listFiles();
            for (File el : listFiles) {
                System.out.println(el);
                System.out.println(el.isHidden());
                if (el.isDirectory()) {
                    File dest = Paths.get(el.getParent(), "sample2").toFile();
                    if (el.renameTo(dest)) {
                        System.out.println("renamed to " + dest.getAbsolutePath());
                    } else {
                        System.out.println("can't rename to " + dest.getAbsolutePath());
                        System.out.println("can write? " + dest.canWrite());
                    }
                    System.out.println(el.getName());
                }
            }
        }
    }

    private static void workWithPath() {
        Path p = Paths.get(".")
                .toAbsolutePath()
                .getParent()
                .getParent()
                .getRoot();
        System.out.println(p);
        Path comb = Paths.get("one", "two", "34", "67");
        System.out.println(comb);
        System.out.println(comb.getParent());
        System.out.println(comb.getRoot());
        System.out.println(comb.toAbsolutePath());
        System.out.println(comb.toAbsolutePath().getRoot());

        System.out.println(
                Paths.get(Paths.get("").toAbsolutePath().toString(), "src"));
    }

    /**
     * Вот этот метод очень нужный
     *
     * @param a Это первое значение
     * @param b Это второе значение
     * @return возвращает всегда нолик
     */
    static int some(int a, int b) {
        return 0;
    }
}
