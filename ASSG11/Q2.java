// 2. From an array of strings, use flatMap and sorted to create a single sorted string
// containing every unique character present in the array.

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Q2 {
    public static void main(String[] args) {
        String[] strings = {"hello", "world", "java", "stream"};

        Set<Character> uniqueChars = Arrays.stream(strings)
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(TreeSet::new));

        String result = uniqueChars.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(result);
    }
}