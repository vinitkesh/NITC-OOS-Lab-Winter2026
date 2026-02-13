// 6. Create a class to manage ordered pair of instances of any two data types. The first instance
// of the pair is called as key and the second as a value. It should getKey() and getValue()
// methods. Write a Java program incorporating the following main function.
// public static void main(String[] args) {
// // Your provided code:
// OrderedPair<String, Integer> p1 = new OrderedPair<String,
// Integer>("Even", 8);
// OrderedPair<String, String> p2 = new OrderedPair<String,
// String>("hello", "world");
// }

// Generic class OrderedPair with two data types
class OrderedPair<K, V> {

    private K key;
    private V value;

    // Constructor
    public OrderedPair(K key, V value) {
        this.key = key;     // using this keyword
        this.value = value;
    }

    // Getter for key
    public K getKey() {
        return key;
    }

    // Getter for value
    public V getValue() {
        return value;
    }
}

public class Q6 {
    public static void main(String[] args) {

        // Given objects
        OrderedPair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);

        OrderedPair<String, String> p2 = new OrderedPair<String, String>("hello", "world");

        // Printing values to verify
        System.out.println("p1 Key: " + p1.getKey());
        System.out.println("p1 Value: " + p1.getValue());

        System.out.println("p2 Key: " + p2.getKey());
        System.out.println("p2 Value: " + p2.getValue());
    }
}


