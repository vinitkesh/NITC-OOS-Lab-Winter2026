import java.util.Arrays;

public class Q13 {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 4, 5};

        int product = Arrays.stream(numbers)
                .reduce(1, (a, b) -> a * b);

        System.out.println("Product: " + product);
    }
}
