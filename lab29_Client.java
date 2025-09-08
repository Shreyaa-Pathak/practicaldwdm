import java.io.*;
import java.net.*;
import java.util.Scanner;

public class lab29_Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter message to send to server: ");
        String message = sc.nextLine();

        try {
            Socket socket = new Socket("localhost", 5000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send message to server
            out.println(message);

            // Receive reversed message from server
            String reversed = in.readLine();
            System.out.println("Server reversed message: " + reversed);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
