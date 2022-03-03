package ru.capchik.samsungandroid2021.iep0321.l220303;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class WorkUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(6758);
        byte[] buffer = new byte[2048];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        System.out.println("listening...");
        while (true){
            datagramSocket.receive(packet);
            System.out.println("received !");
            System.out.println("  ip: " + packet.getAddress());
            System.out.println("  port: " + packet.getPort());
            System.out.println("  message: " + new String(
                    packet.getData(),
                    packet.getOffset(),
                    packet.getLength()));
            packet.setLength(2);
            datagramSocket.send(packet);
        }
    }
}
