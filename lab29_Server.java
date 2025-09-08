import java.io.*;
import java.net.*;

public class lab29_Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // receive message from client
            String message = in.readLine(); 

            // Reverse the message
            String reversed = new StringBuilder(message).reverse().toString();

            // Send reversed message back to client
            out.println(reversed);

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
