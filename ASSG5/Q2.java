// Design a vehicle management system that involves multiple levels of inheritance, as well as
// multiple classes inheriting from the same base class. The system includes a Vehicle class as
// the base class, and several derived classes like Car, Bus. Additionally, extend the Car class
// further into more specialized classes like ElectricCar and SportsCar. You also have scenarios
// where different classes like SUV and Sedan inherit from the Car class.

class Vehicle {
    private String make;
    private String model;
    private int year;
    private String color;
    private String currentSpeed;


    Vehicle(String make, String model, int year, String color, String currentSpeed) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.currentSpeed = currentSpeed;
    }

    public void accelerate(int increment) {
        System.out.println("The vehicle accelerates by " + increment + " mph.");
    }
    public void brake(int decrement) {
        System.out.println("The vehicle slows down by " + decrement + " mph.");
    }
    public void turnLeft() {
        System.out.println("The vehicle turns left.");
    }
    public void turnRight() {
        System.out.println("The vehicle turns right.");
    }

    void displayInfo() {
        System.out.println(year + " " + make + " " + model);
    }
}

class Car extends Vehicle {
    private int numDoors;
    private String trunkCapacity;

    Car(String make, String model, int year, String color, String currentSpeed, int numDoors, String trunkCapacity) {
        super(make, model, year, color, currentSpeed);
        this.numDoors = numDoors;
        this.trunkCapacity = trunkCapacity;
    }

    public void openTrunk() {
        System.out.println("The trunk is opened.");
    }

    public void closeTrunk() {
        System.out.println("The trunk is closed.");
    }


}

class Bus extends Vehicle {
    private int numSeats;
    private String routeNumber;
    private Boolean isDoubleDecker;

    Bus(String make, String model, int year, String color, String currentSpeed, int numSeats, String routeNumber, Boolean isDoubleDecker) {
        super(make, model, year, color, currentSpeed);
        this.numSeats = numSeats;
        this.routeNumber = routeNumber;
        this.isDoubleDecker = isDoubleDecker;
    }

    public void openDoors() {
        System.out.println("The bus doors are opened.");
    }

    public void closeDoors() {
        System.out.println("The bus doors are closed.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Route Number: " + routeNumber + ", Seats: " + numSeats + ", Double Decker: " + isDoubleDecker);
    }
}

class SUV extends Car {
    private String offroadCapability;

    SUV(String make,
        String model,
        int year,
        String color,
        String currentSpeed,
        int numDoors,
        String trunkCapacity, 
        String offroadCapability
    ) {
        super(make, model, year, color, currentSpeed, numDoors, trunkCapacity);
        this.offroadCapability = offroadCapability;
    }

    public void engage4WD() {
        System.out.println("4-Wheel Drive enabled.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Offroad Capability: " + offroadCapability);
    }
}

class Sedan extends Car {
    private Boolean luxuryInterior;

    Sedan(String make,
          String model,
          int year,
          String color,
          String currentSpeed,
          int numDoors,
          String trunkCapacity,
          Boolean luxuryInterior
    ) {
        super(make, model, year, color, currentSpeed, numDoors, trunkCapacity);
        this.luxuryInterior = luxuryInterior;
    }

    public void activateMassageSeats() {
        System.out.println("Massage seats activated.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Luxury Interior: " + luxuryInterior);
    }
}

class ElectricCar extends Car {
    private int batteryCapacity;

    ElectricCar(String make,
                String model,
                int year,
                String color,
                String currentSpeed,
                int numDoors,
                String trunkCapacity,
                int batteryCapacity
    ) {
        super(make, model, year, color, currentSpeed, numDoors, trunkCapacity);
        this.batteryCapacity = batteryCapacity;
    }

    public void chargeBattery() {
        System.out.println("The electric car is charging.");
    }

    public void accelerate(int increment) {
        System.out.println("The electric car silently accelerates by " + increment + " mph.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

class SportsCar extends Car {
    private int topSpeed;

    SportsCar(String make,
              String model,
              int year,
              String color,
              String currentSpeed,
              int numDoors,
              String trunkCapacity,
              int topSpeed
    ) {
        super(make, model, year, color, currentSpeed, numDoors, trunkCapacity);
        this.topSpeed = topSpeed;
    }

    public void accelerate(int increment) {
        System.out.println("The sports car roars as it accelerates by " + increment + " mph.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Top Speed: " + topSpeed + " mph");
    }
}

public class Q2 {
    public static void main(String[] args) {
        ElectricCar tesla = new ElectricCar("Tesla", "Model S", 2022, "Red", "0 mph", 4, "28 cu ft", 100);
        SportsCar ferrari = new SportsCar("Ferrari", "GTB", 2021, "Yellow", "0 mph", 2, "10 cu ft", 211);
        SUV jeep = new SUV("Jeep", "Wrangler", 2020, "Black", "0 mph", 4, "31 cu ft", "High");
        Sedan bmw = new Sedan("BMW", "5 Series", 2019, "White", "0 mph", 4, "18 cu ft", true);
        Bus cityBus = new Bus("Mercedes-Benz", "Super Bus", 2018, "Blue", "0 mph", 50, "22A", false);

        tesla.displayInfo();
        tesla.chargeBattery();
        tesla.accelerate(30);
        tesla.brake(10);

        ferrari.displayInfo();
        ferrari.accelerate(50);
        ferrari.turnLeft();

        jeep.displayInfo();
        jeep.engage4WD();
        jeep.accelerate(20);

        bmw.displayInfo();
        bmw.activateMassageSeats();
        bmw.accelerate(25);

        cityBus.displayInfo();
        cityBus.openDoors();
        cityBus.accelerate(15);
    }
}