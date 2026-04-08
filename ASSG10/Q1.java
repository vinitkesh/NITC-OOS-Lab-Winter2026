import java.util.ArrayList;
import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        String[] words = {"Apple", "Banana", "Avocado", "Cherry", "Apricot"};

        Arrays.asList(words).forEach(word -> System.out.println(word));

        ArrayList<String> strings = new ArrayList<>();
        strings.add("Apple");
        strings.add("Banana");
        strings.add("Avocado");
        strings.add("Cherry");
        strings.add("Apricot");

        strings.forEach(word -> System.out.println(word));
        strings.forEach(System.out::println);
        

    }
}
