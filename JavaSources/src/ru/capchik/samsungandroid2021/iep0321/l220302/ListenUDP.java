package ru.capchik.samsungandroid2021.iep0321.l220302;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ListenUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(5080);
        byte[] buffer = new byte[2048];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        while (true){
            datagramSocket.receive(packet);
            // packet = datagramSocket.receive();
            System.out.println("RECEIVED!");
            System.out.println(packet.getLength());
            byte[] data = packet.getData();
            System.out.println(data);
            System.out.println(new String(
                    packet.getData(),
                    packet.getOffset(),
                    packet.getLength()));
            System.out.println(packet.getAddress());
            System.out.println(packet.getPort());
            packet.setLength(packet.getLength() / 2);
            datagramSocket.send(packet);
        }
    }
}
