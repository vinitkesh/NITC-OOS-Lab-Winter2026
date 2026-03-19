import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q7 {
    public static void main(String[] args) {
        String[] words = {"Apple", "Banana", "Avocado", "Cherry", "Apricot", "Mango"};

        List<String> aWordsList = Arrays.stream(words)
                .filter(word -> word.startsWith("A"))
                .collect(Collectors.toList());

        String[] aWords = aWordsList.toArray(new String[0]);

        System.out.println(Arrays.toString(aWords));
    }
}
