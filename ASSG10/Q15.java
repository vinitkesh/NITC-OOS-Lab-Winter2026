import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Q15 {
    static class Purchase {
        private final String customerName;
        private final String fruitName;

        Purchase(String customerName, String fruitName) {
            this.customerName = customerName;
            this.fruitName = fruitName;
        }

        String getCustomerName() {
            return customerName;
        }

        String getFruitName() {
            return fruitName;
        }
    }

    static class Fruit {
        private final String name;
        private final double pricePerKg;

        Fruit(String name, double pricePerKg) {
            this.name = name;
            this.pricePerKg = pricePerKg;
        }

        String getName() {
            return name;
        }

        double getPricePerKg() {
            return pricePerKg;
        }
    }

    public static void main(String[] args) {
        List<Fruit> fruits = List.of(
                new Fruit("Apple", 120.0),
                new Fruit("Banana", 40.0),
                new Fruit("Orange", 80.0),
                new Fruit("Mango", 150.0)
        );

        List<Purchase> purchases = List.of(
                new Purchase("Asha", "Apple"),
                new Purchase("Ravi", "Banana"),
                new Purchase("Neha", "Apple"),
                new Purchase("Arun", "Mango"),
                new Purchase("Kiran", "Orange"),
                new Purchase("Meera", "Mango"),
                new Purchase("Vijay", "Banana")
        );

        Map<String, Double> fruitPriceMap = fruits.stream()
                .collect(Collectors.toMap(Fruit::getName, Fruit::getPricePerKg));

        Map<String, Double> saleByFruit = purchases.stream()
                .collect(Collectors.groupingBy(
                        Purchase::getFruitName,
                        TreeMap::new,
                        Collectors.summingDouble(purchase ->
                                fruitPriceMap.getOrDefault(purchase.getFruitName(), 0.0))
                ));

        saleByFruit.forEach((fruit, amount) ->
                System.out.println(fruit + " -> " + amount));
    }
}
