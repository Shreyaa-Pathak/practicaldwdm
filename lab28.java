import java.net.*;

public class lab28 {
    public static void main(String[] args) {
        try {
            String domain = "www.google.com";
            InetAddress inet = InetAddress.getByName(domain);

            System.out.println("Host Name: " + inet.getHostName());
            System.out.println("IP Address: " + inet.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
