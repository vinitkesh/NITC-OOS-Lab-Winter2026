import java.util.Arrays;

public class Q6 {
    public static void main(String[] args) {
        String[] words = {"Apple", "Banana", "Avocado", "Cherry", "Apricot", "Mango"};

        Arrays.stream(words)
                .filter(word -> word.startsWith("A"))
                .forEach(System.out::println);
    }
}
