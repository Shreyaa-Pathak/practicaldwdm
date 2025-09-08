import java.net.*;
import java.io.*;

public class lab30_UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9876);
        System.out.println("UDP Server running...");

        byte[] buf = new byte[256];

        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);

        InetAddress address = packet.getAddress();
        int port = packet.getPort();

        int number = Integer.parseInt(new String(packet.getData(), 0, packet.getLength()));
        int square = number * number;

        String s = String.valueOf(square);
        buf = s.getBytes();

        packet = new DatagramPacket(buf, buf.length, address, port);
        socket.send(packet);

        socket.close();
    }
}
