import java.util.Scanner;

public class CalcEngine {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number of your choice: ");
        int var1 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter another number of your choice: ");
        int var2 = scanner.nextInt();
        scanner.nextLine();
        calc.addition(var1, var2);
        calc.subtraction(var1, var2);
        calc.multiplication(var1, var2);
        calc.division(var1, var2);
    }
}

class Calculator{
    public Calculator() {

    }
    protected void addition(int v1, int v2) {
        System.out.println("Addition: " + (v1 + v2));
    }
    protected void subtraction(int v1, int v2) {
        System.out.println("Subtraction: " + (v1 - v2));
    }
    protected void multiplication(int v1, int v2) {
        System.out.println("Multiplication " + (v1 * v2));
    }
    protected void division(int v1, int v2) {
        System.out.println("Division: " + (v1 / v2));
    }
}