// 6. Use flatMap to break a list of sentences into words and use reduce to identify the single
// longest word across the entire list.

import java.util.Arrays;
import java.util.Optional;

public class Q6 {
    public static void main(String[] args) {
        String[] sentences = {
                "Java streams are powerful",
                "They allow for functional programming",
                "FlatMap is useful for breaking down data"
        };

        Optional<String> longestWord = Arrays.stream(sentences)
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .reduce((word1, word2) -> word1.length() >= word2.length() ? word1 : word2);

        longestWord.ifPresent(System.out::println);
    }
}
