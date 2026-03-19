import java.util.Arrays;

public class Q4 {
    public static void main(String[] args) {
        String[] words = {"Apple", "Banana", "Avocado", "Cherry", "Apricot"};

        String[] upperWords = Arrays.stream(words)
                .map(String::toUpperCase)
                .toArray(String[]::new);

        Arrays.stream(upperWords).forEach(System.out::println);
    }
}
