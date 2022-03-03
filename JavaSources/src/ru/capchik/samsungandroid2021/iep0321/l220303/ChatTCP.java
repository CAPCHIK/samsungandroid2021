package ru.capchik.samsungandroid2021.iep0321.l220303;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatTCP {
    public static void main(String[] args) throws IOException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 for listen 2 for connect");
        Socket communicationSocket;
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Enter listen port");
                ServerSocket listenSocket = new ServerSocket(scanner.nextInt());
                System.out.println("listening...");
                Socket socket = listenSocket.accept();
                System.out.println("client socket connected: " + socket.isConnected());
                communicationSocket = socket;
                break;
            case 2:
                System.out.println("Enter target port");
                Socket clientSocket = new Socket();
                clientSocket.connect(new InetSocketAddress("localhost", scanner.nextInt()));
                System.out.println("client socket connected: " + clientSocket.isConnected());
                communicationSocket = clientSocket;
                break;
            default:
                System.out.println("Go out!");
                return;
        }
        Thread readingThread = new Thread(() -> {
            try {
                Scanner socketScanner = new Scanner(communicationSocket.getInputStream());
                while (socketScanner.hasNext()) {
                    String line = socketScanner.nextLine();
                    if (!line.isEmpty()) {
                        System.out.println("Received: " + line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        readingThread.start();
        OutputStreamWriter socketWriter = new OutputStreamWriter(communicationSocket.getOutputStream());
        while (true) {
            socketWriter.write(scanner.nextLine() + "\n");
            socketWriter.flush();
        }
    }
}
