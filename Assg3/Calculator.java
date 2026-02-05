import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            String operator = sc.nextLine();
            int a = Integer.parseInt(sc.nextLine());
            int b = Integer.parseInt(sc.nextLine());

            int result = 0;

            switch (operator) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if (b == 0) {
                        throw new ArithmeticException("Division by zero handled. Enter a valid argument.");
                    }
                    result = a / b;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator");
            }

            System.out.println(result);

        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Enter only digits [0-9]");
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}
