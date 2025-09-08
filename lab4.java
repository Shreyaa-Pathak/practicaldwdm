import java.util.Scanner;

public class lab4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the first integer: ");
            int num1 = sc.nextInt();

            System.out.print("Enter the second integer: ");
            int num2 = sc.nextInt();

            int result = num1 / num2;
            System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
        } 
        catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } 
        catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter integers only.");
        } 
        finally {
            sc.close();
            System.out.println("Program ended.");
        }
    }
}
