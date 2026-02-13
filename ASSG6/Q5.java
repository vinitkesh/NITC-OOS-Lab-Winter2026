// Given the following multi-level class hierarchy in Java:
    // - Level 1: Vehicle (Base class)
    // - Level 2: Car (Inherits from Vehicle)
    // - Level 3: ElectricCar (Inherits from Car)
    // - Level 4: Tesla (Inherits from ElectricCar)
// Each class has a method start() that is overridden in the derived classes, with the derived
// classes adding additional functionality. The super keyword is used to invoke the start() method
// of the parent class within each overridden method. The this keyword is used within constructors
// to initialize class-specific attributes.
    // 1. Task 1: Implement this class hierarchy in Java. The Vehicle class should have a general
    // start() method, which is then overridden by each subclass to add more specific
    // functionality (e.g., starting a Car, an ElectricCar, and a Tesla).
    // 2. Task 2: In the main() method, create an instance of the Tesla class and call the start()
    // method.

// Level 1: Vehicle (Base class)
class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;   
    }

    public void start() {
        System.out.println("Starting a vehicle");
    }
}

class Car extends Vehicle {
    protected String model;

    public Car(String brand, String model) {
        super(brand);         
        this.model = model;  
    }

    @Override
    public void start() {
        super.start();  
        System.out.println("Starting the car: " + brand + " " + model);
    }
}

// Level 3: ElectricCar (Inherits from Car)
class ElectricCar extends Car {
    protected int batteryCapacity;

    public ElectricCar(String brand, String model, int batteryCapacity) {
        super(brand, model);          // calling Car constructor
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void start() {
        super.start();  // calling Car's start()
        System.out.println("Powering electric motor with battery capacity: " 
                            + batteryCapacity + " kWh");
    }
}

// Level 4: Tesla (Inherits from ElectricCar)
class Tesla extends ElectricCar {
    private String autopilotVersion;

    public Tesla(String brand, String model, int batteryCapacity, String autopilotVersion) {
        super(brand, model, batteryCapacity);  // calling ElectricCar constructor
        this.autopilotVersion = autopilotVersion;
    }

    @Override
    public void start() {
        super.start();  // calling ElectricCar's start()
        System.out.println("Initializing Tesla Autopilot Version: " 
                            + autopilotVersion);
    }
}

// Main class
public class Q5 {
    public static void main(String[] args) {
        // Task 2: Create Tesla object and call start()
        Tesla myTesla = new Tesla("Tesla", "Model S", 100, "v12.3");
        myTesla.start();
    }
}

