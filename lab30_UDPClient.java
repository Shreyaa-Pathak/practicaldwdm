import java.net.*;
import java.io.*;
import java.util.Scanner;

public class lab30_UDPClient {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        DatagramSocket socket = new DatagramSocket();

        byte[] buf = String.valueOf(number).getBytes();
        InetAddress address = InetAddress.getByName("localhost");

        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 9876);
        socket.send(packet);

        packet = new DatagramPacket(new byte[256], 256);
        socket.receive(packet);

        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Square from server: " + received);

        socket.close();
        sc.close();
    }
}
