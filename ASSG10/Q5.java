import java.util.Arrays;

public class Q5 {
    public static void main(String[] args) {
        String[] words = {"Apple", "Banana", "Avocado", "Cherry", "Apricot"};

        Integer[] charCounts = Arrays.stream(words)
                .map(String::length)
                .toArray(Integer[]::new);

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i] + " -> " + charCounts[i]);
        }
    }
}
