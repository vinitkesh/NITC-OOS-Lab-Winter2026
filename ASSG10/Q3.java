
public class Q3 {
    public static void main(String[] args) {
        String[] words = {"Apple", "Banana", "Avocado", "Cherry", "Apricot"};
        String[] upperWords = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            upperWords[i] = words[i].toUpperCase();
        }

        for (String word : upperWords) {
            System.out.println(word);
        }
    }
}
