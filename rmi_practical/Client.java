package rmi_practical;

import java.rmi.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Factorial stub = (Factorial) Naming.lookup("//localhost/FactorialService");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int n = sc.nextInt();

            long result = stub.getFactorial(n);
            System.out.println("Factorial of " + n + " is: " + result);
        } catch (Exception e) {
            System.out.println("Client failed: " + e);
        }
    }
}
