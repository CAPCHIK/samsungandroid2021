package ru.capchik.samsungandroid2021.iep0321.l220303;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ListenTCP {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9830);
        Socket acceptedSocket = serverSocket.accept();
        System.out.println("Client connected");
        Scanner scanner = new Scanner(acceptedSocket.getInputStream());
        OutputStreamWriter writer = new OutputStreamWriter(
                acceptedSocket.getOutputStream()
        );
//        writer.write("Hello!");
//        writer.flush();
        writer.write("HTTP/1.1 200 OK\r\n" +
                "Server: SamsungCourse/2.2.14 (Win32)\r\n" +
                "Content-Length: 12\r\n" +
                "Content-Type: text/plain\r\n" +
                "Connection: Closed\r\n\r\n" +
                "Hello world!");
        writer.flush();
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            System.out.println(line);
//            writer.write("Thanks for string");
//            writer.flush();
        }

    }
}
