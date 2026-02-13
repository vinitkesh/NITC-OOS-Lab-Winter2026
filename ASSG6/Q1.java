
import java.util.ArrayList;
import java.util.List;

// .Create a simple inventory management system using generics and inheritance. You need to
// implement a generic class Inventory<T> where T is a subtype of a base class Product. 
// The Inventory class should manage a collection of products and provide the following functionalities:
    // 1. addProduct(T product): Adds a product to the inventory.
    // 2. removeProduct(T product): Removes a product from the inventory.
    // 3. listProducts(): Lists all products in the inventory.

// Create a base class Product with a name property, and two subclasses Electronics and
// Clothing, where Electronics has an additional warrantyPeriod property, and Clothing has an
// additional size property.

class Inventory<T extends Product> {
    
    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public void removeProduct(T product) {
        products.remove(product);
    }

    public void listProducts() {
        for (T product : products) {
            System.out.println(product.name);
        }
    }
}

class Product {
    // Implementation goes here
    String name;
    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "'}";
    }
}

class Electronics extends Product {
    // Implementation goes here
    int warrantyPeriod;

    public Electronics(String name, int warrantyPeriod) {
        super(name);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String toString() {
        return "Electronics{name='" + name + "', warrantyPeriod=" + warrantyPeriod + "}";
    }
}

class Clothing extends Product {
    // Implementation goes here
    String size;
    public Clothing(String name, String size) {
        super(name);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Clothing{name='" + name + "', size='" + size + "'}";
    }
}

class NotProduct{
    String description;
    public NotProduct(String description) {
        this.description = description;
    }
}
public class Q1 {
    public static void main(String[] args) {
        Inventory<Product> productInventory = new Inventory<>();
        Electronics laptop = new Electronics("Laptop", 24);
        Electronics smartphone = new Electronics("Smartphone", 12);
        Clothing tshirt = new Clothing("T-Shirt", "M");

        NotProduct notAProduct = new NotProduct("Just a description");

        productInventory.addProduct(laptop);
        productInventory.addProduct(smartphone);
        productInventory.addProduct(tshirt);
        // productInventory.addProduct(notAProduct);

        productInventory.listProducts();
    }    


}
