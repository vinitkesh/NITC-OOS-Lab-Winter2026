import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        String[] words = {"Apple", "Banana", "Avocado", "Cherry", "Apricot"};

        Arrays.asList(words).forEach(System.out::println);
    }
}
