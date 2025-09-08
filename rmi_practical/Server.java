package rmi_practical;

import java.rmi.*;

public class Server {
    public static void main(String[] args) {
        try {
            FactorialImpl skeleton = new FactorialImpl();
            Naming.rebind("//localhost/FactorialService", skeleton);
            System.out.println("Factorial Server is ready.");
        } catch (Exception e) {
            System.out.println("Server failed: " + e);
        }
    }
}

