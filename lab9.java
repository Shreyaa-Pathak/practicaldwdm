import java.io.IOException;
import java.io.RandomAccessFile;

public class lab9 {
    public static void main(String[] args) {
        String filename = "randomfile.txt";

        RandomAccessFile raf = null;

        try {
            raf = new RandomAccessFile(filename, "rw");

            raf.seek(0); 
            raf.writeUTF("Hello"); 

            raf.seek(20); 
            raf.writeUTF("World"); 

            raf.seek(10); 
            raf.writeUTF("Java"); 

            System.out.println("Data written successfully.");

            raf.seek(0);
            System.out.println("Data at position 0: " + raf.readUTF());

            raf.seek(10);
            System.out.println("Data at position 10: " + raf.readUTF());

            raf.seek(20);
            System.out.println("Data at position 20: " + raf.readUTF());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf != null) raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
