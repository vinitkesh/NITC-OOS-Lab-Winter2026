// You are working on an e-commerce application where you need to calculate the total
// price of an order. The system should handle different types of orders:
// 1. Single Item: The total price is calculated based on the price of a single item and its
// quantity.
// 2. Multiple Items: The total price is calculated based on multiple item prices and
// quantities.
// 3. Discounted Order: The total price includes a discount, so you need to apply a
// percentage discount on the total price.

// Implement a method calculateTotalPrice() using method overloading to handle the
// following scenarios:
    // - Calculate the total price for a single item (quantity and price).
    // - Calculate the total price for multiple items (arrays of prices and quantities).
    // - Calculate the total price for an order that includes a discount (total price and
// discount percentage).

// Order class with method overloading for calculating total price based on different scenarios.

class Order {
    // Method to calculate total price for a single item
    public double calculateTotalPrice(double price, int quantity) {
        return price * quantity;
    }

    // Method to calculate total price for multiple items
    public double calculateTotalPrice(double[] prices, int[] quantities) {
        double totalPrice = 0;
        for (int i = 0; i < prices.length; i++) {
            totalPrice += prices[i] * quantities[i];
        }
        return totalPrice;
    }

    // Method to calculate total price with discount
    public double calculateTotalPrice(double totalPrice, double discountPercentage) {
        return totalPrice - (totalPrice * discountPercentage / 100);
    }
}

public class Q4 {
    public static void main(String[] args) {
        Order order = new Order();

        // Calculate total price for a single item
        double singleItemTotal = order.calculateTotalPrice(100.0, 2);
        System.out.println("Total price for single item: " + singleItemTotal);

        // Calculate total price for multiple items
        double[] prices = {50.0, 30.0, 20.0};
        int[] quantities = {2, 3, 1};
        double multipleItemsTotal = order.calculateTotalPrice(prices, quantities);
        System.out.println("Total price for multiple items: " + multipleItemsTotal);

        // Calculate total price with discount
        double discountedTotal = order.calculateTotalPrice(multipleItemsTotal, 10);
        System.out.println("Total price after discount: " + discountedTotal);
    }
}


