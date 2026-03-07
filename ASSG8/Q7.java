// Assume that Ram is the owner of a Factory who owns so many cars and trucks. He
// needs to keep track of his vehicles based on the total tax that should be paid every
// month. For this purpose, implement a management system with the help of OOP. In the
// design of the management system, it is decided that there should be a class Vehicle that
// stores the modelNumber, rateBought, fuelType (possible values are "petrol" and "diesel")
// and numberOfWheels. Create the derived classes, Car that has one more attribute
// numberOfPassengers and Truck that has the extra attribute loadLimit. For Car, the
// numberOfWheels is 4 and for Truck numberOfWheels is 6 by default. There should be
// one interface TaxCalculatable, which has a method calculateTax. Vehicle class should
// implement this interface, and the tax calculations should be as follows.
    // For Car with fuelType petrol , total tax amount is (rateBought*0.1 *
    // numberOfPassengers)*0.5
    // For Car with fuelType diesel, total tax amount is (rateBought*0.1 *
    // numberOfPassengers)*0.4
    // For Truck with fuelType petrol , total tax amount is (rateBought*0.1 *
    // loadLimit*0.002)*0.5
    // For Truck with fuelType diesel, total tax amount is (rateBought*0.1 * loadLimit*0.002)*0.4
// Write a Java program to create a vehicle management system where a list of vehicles of
// these two derived classes should be stored and displayed. While displaying the
// information about the stored vehicles, display vehicles in the decreasing order of total
// tax.

interface TaxCalculatable {
    double calculateTax();
}

class Vehicle implements TaxCalculatable {
    protected String modelNumber;
    protected double rateBought;
    protected String fuelType;
    protected int numberOfWheels;

    public Vehicle(String modelNumber, double rateBought, String fuelType, int numberOfWheels) {
        this.modelNumber = modelNumber;
        this.rateBought = rateBought;
        this.fuelType = fuelType;
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public double calculateTax() {
        return 0; // This will be overridden in derived classes
    }
}

class Car extends Vehicle {
    private int numberOfPassengers;

    public Car(String modelNumber, double rateBought, String fuelType, int numberOfPassengers) {
        super(modelNumber, rateBought, fuelType, 4);
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public double calculateTax() {
        double baseTax = rateBought * 0.1 * numberOfPassengers;
        if (fuelType.equals("petrol")) {
            return baseTax * 0.5;
        } else if (fuelType.equals("diesel")) {
            return baseTax * 0.4;
        }
        return 0;
    }
}

class Truck extends Vehicle {
    private double loadLimit;

    public Truck(String modelNumber, double rateBought, String fuelType, double loadLimit) {
        super(modelNumber, rateBought, fuelType, 6);
        this.loadLimit = loadLimit;
    }

    @Override
    public double calculateTax() {
        double baseTax = rateBought * 0.1 * loadLimit * 0.002;
        if (fuelType.equals("petrol")) {
            return baseTax * 0.5;
        } else if (fuelType.equals("diesel")) {
            return baseTax * 0.4;
        }
        return 0;
    }
}

public class Q7 {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("ModelX", 50000, "petrol", 5),
            new Car("ModelY", 60000, "diesel", 4),
            new Truck("TruckA", 80000, "petrol", 1000),
            new Truck("TruckB", 90000, "diesel", 1500)
        };

        // Sort vehicles by tax in decreasing order
        java.util.Arrays.sort(vehicles, (v1, v2) -> Double.compare(v2.calculateTax(), v1.calculateTax()));

        // Display vehicle information
        for (Vehicle vehicle : vehicles) {
            System.out.println("Model: " + vehicle.modelNumber + ", Fuel Type: " + vehicle.fuelType + ", Tax: " + vehicle.calculateTax());
        }
        
    }
}


// 7. Assume that Ram is the owner of a Factory who owns so many cars and trucks. He
// needs to keep track of his vehicles based on the total tax that should be paid every
// month. For this purpose, implement a management system with the help of OOP. In the
// design of the management system, it is decided that there should be a class Vehicle that
// stores the modelNumber, rateBought, fuelType (possible values are “petrol” and “diesel”)
// and numberOfWheels. Create the derived classes, Car that has one more attribute
// numberOfPassengers and Truck that has the extra attribute loadLimit. For Car, the
// numberOfWheels is 4 and for Truck numberOfWheels is 6 by default. There should be
// one interface TaxCalculatable, which has a method calculateTax. Vehicle class should
// implement this interface, and the tax calculations should be as follows.
// For Car with fuelType petrol , total tax amount is (rateBought*0.1 *
// numberOfPassengers)*0.5
// For Car with fuelType diesel, total tax amount is (rateBought*0.1 *
// numberOfPassengers)*0.4
// For Truck with fuelType petrol , total tax amount is (rateBought*0.1 *
// loadLimit*0.002)*0.5
// For Truck with fuelType diesel, total tax amount is (rateBought*0.1 * loadLimit*0.002)*0.4
// Write a Java program to create a vehicle management system where a list of vehicles of
// these two derived classes should be stored and displayed. While displaying the
// information about the stored vehicles, display vehicles in the decreasing order of total
// tax.

// IMPORTANT CONCEPTS I USED HERE-
// Interfaces	TaxCalculatable Comparable (inbuilt)
// Multiple interface inheritance	Vehicle implements TaxCalculatable, Comparable

// Polymorphism	ArrayList<Vehicle> storing different objects

// Method overriding	calculateTax()

// abstract class Vehicle
import java.util.*;

interface TaxCalculatable {
    double calculateTax();
}

abstract class Vehicle implements TaxCalculatable, Comparable<Vehicle> {
    String modelNumber;
    double rateBought;
    String fuelType;
    int numberOfWheels;

    Vehicle(String modelNumber, double rateBought, String fuelType, int numberOfWheels) {
        this.modelNumber = modelNumber;
        this.rateBought = rateBought;
        this.fuelType = fuelType;
        this.numberOfWheels = numberOfWheels;
    }

    public int compareTo(Vehicle v) {
        return Double.compare(v.calculateTax(), this.calculateTax()); 
        // decreasing order of tax
    }
}

class Car extends Vehicle {
    int numberOfPassengers;

    Car(String modelNumber, double rateBought, String fuelType, int numberOfPassengers) {
        super(modelNumber, rateBought, fuelType, 4);
        this.numberOfPassengers = numberOfPassengers;
    }

    public double calculateTax() {
        double base = rateBought * 0.1 * numberOfPassengers;

        if (fuelType.equalsIgnoreCase("petrol"))
            return base * 0.5;
        else
            return base * 0.4;
    }
}

class Truck extends Vehicle {
    double loadLimit;

    Truck(String modelNumber, double rateBought, String fuelType, double loadLimit) {
        super(modelNumber, rateBought, fuelType, 6);
        this.loadLimit = loadLimit;
    }

    public double calculateTax() {
        double base = rateBought * 0.1 * loadLimit * 0.002;

        if (fuelType.equalsIgnoreCase("petrol"))
            return base * 0.5;
        else
            return base * 0.4;
    }
}

public class Main7 {
    public static void main(String[] args) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("C101", 500000, "petrol", 5));
        vehicles.add(new Car("C102", 600000, "diesel", 4));
        vehicles.add(new Truck("T201", 900000, "diesel", 10000));
        vehicles.add(new Truck("T202", 800000, "petrol", 8000));

        Collections.sort(vehicles); // uses compareTo()

        for (Vehicle v : vehicles) {
            System.out.println("Model Number: " + v.modelNumber);
            System.out.println("Fuel Type: " + v.fuelType);
            System.out.println("Wheels: " + v.numberOfWheels);
            System.out.println("Tax: " + v.calculateTax());
            System.out.println("------------------");
        }
    }
}