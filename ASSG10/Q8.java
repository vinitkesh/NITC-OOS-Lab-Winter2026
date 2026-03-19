import java.util.Arrays;
import java.util.function.Predicate;

public class Q8 {
    public static String[] filterWords(String[] words, Predicate<String> condition) {
        return Arrays.stream(words)
                .filter(condition)
                .toArray(String[]::new);
    }
    public static void main(String[] args) {
        String[] words = {"Apple", "Banana", "Avocado", "Cherry", "Apricot", "Mango"};

        Predicate<String> startsWithA = word -> word.startsWith("A");

        String[] filteredWords = filterWords(words, startsWithA);

        System.out.println(Arrays.toString(filteredWords));
    }
}
