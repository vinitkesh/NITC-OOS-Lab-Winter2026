// Create a Java class for calculator which supports addition and subtraction. The
// functionalities should support addition and subtraction of 2 integers, 3 integers, 2 double
// values and 3 double values. The function names for different types of arguments should
// not be different.

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double add(double a, double b, double c) {
        return a + b + c;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int subtract(int a, int b, int c) {
        return a - b - c;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double subtract(double a, double b, double c) {
        return a - b - c;
    }
}   

public class Q2 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("Addition of 2 integers: " + calculator.add(5, 10));
        System.out.println("Addition of 3 integers: " + calculator.add(5, 10, 15));
        System.out.println("Addition of 2 doubles: " + calculator.add(5.5, 10.5));
        System.out.println("Addition of 3 doubles: " + calculator.add(5.5, 10.5, 15.5));

        System.out.println("Subtraction of 2 integers: " + calculator.subtract(10, 5));
        System.out.println("Subtraction of 3 integers: " + calculator.subtract(15, 10, 5));
        System.out.println("Subtraction of 2 doubles: " + calculator.subtract(10.5, 5.5));
        System.out.println("Subtraction of 3 doubles: " + calculator.subtract(15.5, 10.5, 5.5));
        
    }
}
