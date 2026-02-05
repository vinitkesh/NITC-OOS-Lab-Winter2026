// Write a java program to show the prices of the product. Design a class for the product
// with the product name and the price. Show the products to the user in the ascending
// order of the price or in the descending order of the price based on user’s choice

// Hint: Make use of Collections.sort() and Collections.reverse(). You can create product
// instances in the main(). No need to take the product details from the user.


class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return name + ": $" + price;
    }
}

public class Q1{
    public static void main(String[] args) {
        java.util.List<Product> products = new java.util.ArrayList<>();
        products.add(new Product("Laptop", 999.99));
        products.add(new Product("Smartphone", 499.99));
        products.add(new Product("Tablet", 299.99));
        products.add(new Product("Monitor", 199.99));

        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Enter 1 for ascending order or 2 for descending order of prices:");
        int choice = sc.nextInt();

        switch(choice){
            case (1):
                products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
                System.out.println("Products in ascending order of price:");
                break;
            case (2):
                products.sort((p1, p2) -> Double.compare(p2.price, p1.price));
                System.out.println("Products in descending order of price:");
                break;
            default:
                System.out.println("Invalid choice.");
                sc.close();
                return;
        }

        for (Product p : products) {
            System.out.println(p.toString());
        }
        sc.close();
    }
    
}