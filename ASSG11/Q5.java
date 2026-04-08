// 5. Given a list of Product objects, use groupingBy and counting to create a Map that shows
// the total number of products in each category.

class Product {
        String name;
        String category;

        public Product(String name, String category) {
            this.name = name;
            this.category = category;
        }

        public String getCategory() {
            return category;
        }
    }

public class Q5 {
    
    public static void main(String[] args) {
        Product[] products = {
                new Product("Laptop", "Electronics"),
                new Product("Shirt", "Clothing"),
                new Product("Phone", "Electronics"),
                new Product("Pants", "Clothing"),
                new Product("Headphones", "Electronics")
        };

        java.util.Map<String, Long> productCountByCategory = java.util.Arrays.stream(products)
                .collect(java.util.stream.Collectors.groupingBy(Product::getCategory, java.util.stream.Collectors.counting()));

        productCountByCategory.forEach((category, count) -> System.out.println(category + ": " + count));
    }
}
