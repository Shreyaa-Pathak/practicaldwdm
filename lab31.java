import java.io.*;
import java.net.*;

public class lab31 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://upload.wikimedia.org/wikipedia/commons/3/3f/Fronalpstock_big.jpg");

            // Open connection and set User-Agent
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            InputStream in = connection.getInputStream();
            FileOutputStream out = new FileOutputStream("downloaded.jpg");

            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }

            in.close();
            out.close();
            System.out.println("Image downloaded successfully as downloaded.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
