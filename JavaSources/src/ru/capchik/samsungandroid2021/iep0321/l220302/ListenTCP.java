package ru.capchik.samsungandroid2021.iep0321.l220302;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ListenTCP {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8090);
        Socket accept = serverSocket.accept();
        Scanner scanner = new Scanner(accept.getInputStream());
        OutputStreamWriter writer = new OutputStreamWriter(
                accept.getOutputStream()
        );
        writer.write("HTTP/1.1 200 OK\r\n" +
                "Date: Mon, 27 Jul 2009 12:28:53 GMT\r\n" +
                "Server: Apache/2.2.14 (Win32)\r\n" +
                "Last-Modified: Wed, 22 Jul 2009 19:15:56 GMT\r\n" +
                "Content-Length: 0\r\n" +
                "Connection: Closed\r\n\r\n");
        writer.flush();
        while (scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }
    }
}
