// You are building a dynamic pricing system for an e-commerce platform. The system
// needs to categorize products into price tiers.
// BUDGET: Rs.0 - Rs. 100
// STANDARD: Rs.101 - Rs.500
// PREMIUM: Rs.501 - Rs. 1500
// LUXURY: Rs. 1501+


// When the user inputs a price, the program should be able to find the name of the price
// range.
// Hint: Use TreeMap.

import java.util.Map;
import java.util.TreeMap;


class PriceTier {
    private final TreeMap<Double, String> priceTiers;

    public PriceTier() {
        priceTiers = new TreeMap<>();
        priceTiers.put(0.0, "BUDGET");
        priceTiers.put(101.0, "STANDARD");
        priceTiers.put(501.0, "PREMIUM");
        priceTiers.put(1501.0, "LUXURY");
    }

    public String getPriceTier(double price) {
        Map.Entry<Double, String> entry = priceTiers.floorEntry(price);
        if (entry != null) {
            return entry.getValue();
        }
        return "No Tier Found";
    }
}

class Q6 {
    public static void main(String[] args) {
        PriceTier priceTier = new PriceTier();
        double[] testPrices = {50.0, 150.0, 600.0, 2000.0};

        for (double price : testPrices) {
            String tier = priceTier.getPriceTier(price);
            System.out.println("Price: Rs." + price + " falls under the tier: " + tier);
        }

        // inputting prices and getting their tiers
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Enter a price to find its tier (or type 'exit' to quit):");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                double price = Double.parseDouble(input);
                String tier = priceTier.getPriceTier(price);
                System.out.println("Price: Rs." + price + " falls under the tier: " + tier);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid price or 'exit' to quit.");
            }
        }
    }
}