import java.util.Arrays;

// Get the sum of all the characters in the given list of words using stream and
// mpToInt.

public class Q9 {
    public static void main(String[] args) {
        String[] words = {"Apple", "Banana", "Avocado", "Cherry", "Apricot", "Mango"};

        int totalCharacters = Arrays.stream(words)
                .mapToInt(String::length)
                .sum();

        System.out.println("Total characters: " + totalCharacters);
    }
}
