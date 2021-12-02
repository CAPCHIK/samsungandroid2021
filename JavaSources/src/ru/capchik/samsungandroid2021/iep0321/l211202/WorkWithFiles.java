package ru.capchik.samsungandroid2021.iep0321.l211202;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class WorkWithFiles {
    public static void main(String[] args) throws InterruptedException {
        Path workDir = Paths.get("src/ru/capchik/samsungandroid2021/iep0321/l211202")
                .toAbsolutePath();
        System.out.println(workDir);
        File src = new File(workDir.toString(), "src.jpg");
        File dest = new File(workDir.toString(), "dest.jpg");
        try (InputStream inpStream = new FileInputStream(src);
             FileOutputStream destStream = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int read;

            inpStream.mark(100);
            inpStream.markSupported();

            inpStream.skip(50);
            inpStream.reset();

            while ((read = inpStream.read(buffer)) != -1){
                destStream.write(buffer, 0, read);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void workWithReading(Path workDir) {
        File hwFile = new File(workDir.toString(), "rand.txt");

        if(!hwFile.isFile()){
            System.out.println("file not found");
            return;
        }
        System.out.println("#1");
        try (FileReader fileReader = new FileReader(hwFile)) {
            char[] symbol = new char[2048];
            int read;
            long size = 0;
            while ((read = fileReader.read(symbol)) != -1) {
                size += read;
//                System.out.print(new String(symbol, 0, read));
            }
            System.out.println("Content was read: " + size);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fine not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println("#2");
//        try(Scanner scanner = new Scanner(hwFile)) {
//            String s = scanner.nextLine();
////            System.out.println(s);
//            System.out.println(s.length());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        System.out.println("#3");
        try {
            String content = Files.readString(hwFile.toPath());
//            System.out.println(content);
            System.out.println(content.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void useControlSymbols() throws InterruptedException {
        // LF : \n
        // CRLF : \r\n
        // CR : \r
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(""+i);
                Thread.sleep(500);
            }
            System.out.print("\r");
        }

        System.out.println("\n===");
    }

    private static void workWithSubDirs(Path workDir) {
        File[] files = workDir.toFile().listFiles();
        for (File file : files) {
            System.out.println(file.getName());
            if (file.isDirectory()) {
                File[] filesInSubDir = file.listFiles();
                for (File fileInSubDir : filesInSubDir) {
                    System.out.println("-- " +
                            fileInSubDir.isHidden() + " " +
                            fileInSubDir.getName());
                }
            }
        }
    }

    private static void workWithFiles(Path workDir) {
        File f = new File(workDir.toString(), "file.txt");
        System.out.println(f);
        System.out.println("exists: " + f.exists());
        System.out.println(f.isDirectory());

        File wd = workDir.toFile();
        System.out.println(wd);
        System.out.println(wd.exists());
        System.out.println(wd.isDirectory());

        File subFile = new File(wd, "content.txt");
        System.out.println(subFile);
        System.out.println("file? " + subFile.isFile());
        System.out.println("dir? " + subFile.isDirectory());
        System.out.println("exist? " + subFile.exists());

        doSome(65, 90);
    }


    /**
     * Hello from JavaDocs
     *
     * @param a First argument
     * @param b Second argument
     * @throws RuntimeException When I want
     */
    public static void doSome(int a, int b) {

    }


    private static void workWithPaths() {
        Path path = Paths.get("src/ru");
        System.out.println(path);
        System.out.println(path.getFileName());
        System.out.println(path.getParent());
        System.out.println(path.getParent().getParent());
        System.out.println(path.getRoot());

        System.out.println(path.toAbsolutePath());
        System.out.println(path.toAbsolutePath().getParent());
        System.out.println(path.toAbsolutePath().getParent().getParent());
        System.out.println(path.toAbsolutePath().getParent().getFileName());
        System.out.println(path.toAbsolutePath().getRoot());

        Path readmePath = Paths.get("..", "README.md")
                .toAbsolutePath();
        System.out.println(readmePath);
        System.out.println(readmePath.getFileName());
    }

    private static void workWithFinally() {
        boolean isLoading = false;
        isLoading = true;
        try {
            // загрузка данных
        } finally {
            isLoading = false;
        }


        try {
            System.out.println("Привет!");
            return;
//            throw new Exception(")0)0)))");
            // Исключение
        } catch (Exception ex) {
            System.out.println("Привет, исключение! " + ex.getMessage());
            throw new RuntimeException(ex);
        } finally {
            System.out.println("Пока!");
        }
    }
}
