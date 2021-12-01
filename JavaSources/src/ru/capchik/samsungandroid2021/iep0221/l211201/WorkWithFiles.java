package ru.capchik.samsungandroid2021.iep0221.l211201;

import com.sun.source.tree.WhileLoopTree;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class WorkWithFiles {
    public static void main(String[] args) {

        Path rootPath = Paths.get("src/ru/capchik/samsungandroid2021/iep0221/l211201")
                .toAbsolutePath();
        System.out.println(rootPath);
        File src = new File(rootPath.toString(), "content.txt");
        File dest = new File(rootPath.toString(), "fromJava.txt");
        try (FileInputStream inputStream = new FileInputStream(src);
             FileOutputStream outStream = new FileOutputStream(dest)) {
            System.out.println(inputStream.markSupported());
            inputStream.mark(10);
            inputStream.skip(10);
            inputStream.reset();;
            byte[] buffer = new byte[1024];
            int read;
            while ((read = inputStream.read(buffer)) != -1){
                outStream.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void workWithReading(Path rootPath) {
        File file = new File(rootPath.toString(), "rand.txt");
        if (!file.isFile() && !file.canRead()) {
            System.out.println("Некорректный файл " + file);
            return;
        }
        System.out.println("#1");
        try (FileReader fileReader = new FileReader(file)) {
            char[] symbols = new char[5];
            int read;
            long size = 0;
            while ((read = fileReader.read(symbols)) != -1) {
//                System.out.print(new String(symbols, 0, read));
                size += read;
            }
//            System.out.println("File was read");
            System.out.println(size);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("#2");
        try (Scanner scanner = new Scanner(file)) {
            long size = 0;
            while (scanner.hasNext()) {
//                System.out.println(scanner.nextLine());
                size+= scanner.nextLine().length();
            }
            System.out.println(size);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("#3");
        try {
            String content = Files.readString(file.toPath());
//            System.out.println(content);
            System.out.println(content.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void workWithDirs(Path rootPath) {
        File fileInfo = new File(rootPath.toString());
        System.out.println(fileInfo);
        if (!fileInfo.isDirectory()) {
            System.out.println("path is not dir " + fileInfo.getAbsolutePath());
            return;
        }
        String[] list = fileInfo.list();
        for (String file : list) {
            System.out.println(file);
        }
        File[] listFiles = fileInfo.listFiles();
        for (File file : listFiles) {
            System.out.println((file.isDirectory() ? "DIR " : "FILE ")
                    + (file.isHidden() ? "hidden " : "")
                    + file);
            if (file.isDirectory()) {
                File[] listFiles2 = file.listFiles();
                if (listFiles2 == null) {
                    System.out.println("Родители, обратите внимание " + file.canWrite());
                } else {
                    for (File file2 : listFiles2) {
                        System.out.println(file2);
                    }
                }

            }
        }
        doSome(54, 7);
    }

    /**
     * Do some funny thing
     *
     * @param a first arg
     * @param b second arg
     */
    public static void doSome(int a, int b) {

    }

    private static void workWithPath() {
        Path path = Paths.get("src", "ru", "capchik");
        System.out.println(path.toAbsolutePath());
        Path path1 = Paths.get("src/ru/capchik");
        System.out.println(path1);
        System.out.println(path1.getParent());
        System.out.println(path1.getRoot());
        System.out.println(path.toAbsolutePath().getRoot());
    }

    private static void workWithFinally() throws Exception {
        try {
            System.out.println("So hard code");

            if (true) {
                throw new Exception("Hi");
            }

            System.out.println("So hard code 2");
            System.out.println("So hard code 3");

        } catch (Exception ex) {
            System.out.println("some exception");
            throw ex;
        } finally {
            System.out.println("finally");
        }
    }
}
