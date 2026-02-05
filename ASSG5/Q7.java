
// Imagine you are building a computer program for a large company that needs to track both its
// transportation fleet and its staff members. First, create a general Vehicle category that stores a
// model name and fuel level, then create two specific types, Car and Truck, that inherit from it and
// have their own unique ways of describing how they drive. Second, create a general Employee
// category that stores a name and ID number, then create two specific types, Manager and
// Developer, that inherit from it and have their own unique ways of describing their daily work
// tasks. For all four of these specific types, you must use a constructor to pass the basic
// information (like name or model) up to the parent category.
// Hint: user super

class Vehicle {
    private String modelName;
    private double fuelLevel;

    public Vehicle(String modelName, double fuelLevel) {
        this.modelName = modelName;
        this.fuelLevel = fuelLevel;
    }

    public String getModelName() {
        return modelName;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void drive() {
        System.out.println("The vehicle " + modelName + " is driving.");
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "modelName='" + modelName + '\'' +
                ", fuelLevel=" + fuelLevel +
                '}';
    }
}

class Car extends Vehicle {
    String carType;
    public Car(String modelName, double fuelLevel, String carType) {
        super(modelName, fuelLevel);
        this.carType = carType;
    }

    public void drive() {
        System.out.println("The car " + getModelName() + " is driving smoothly.");
    }

    @Override
    public String toString() {
        return "Car{" +
                "carType='" + carType + '\'' +
                ", modelName='" + getModelName() + '\'' +
                ", fuelLevel=" + getFuelLevel() +
                '}';
    }
}

class Truck extends Vehicle {
    String truckLicense;
    public Truck(String modelName, double fuelLevel, String truckLiecense) {
        super(modelName, fuelLevel);
        this.truckLicense = truckLiecense;
    }

    public void drive() {
        System.out.println("The truck " + getModelName() + " is hauling heavy loads.");
    }

    @Override
    public String toString() {
        return "Truck{" +
                "truckLicense='" + truckLicense + '\'' +
                ", modelName='" + getModelName() + '\'' +
                ", fuelLevel=" + getFuelLevel() +
                '}';
    }
}

class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }   

}

class Manager extends Employee {
    String department;
    public Manager(String name, int id, String department) {
        super(name, id);
        this.department = department;
    }

    public void work() {
        System.out.println("Manager " + getName() + " is managing the team.");
    }

    @Override
    public String toString() {
        return "Manager{" +
                "department='" + department + '\'' +
                ", name='" + getName() + '\'' +
                ", id=" + getId() +
                '}';
    }
}

class Developer extends Employee {
    Manager manager;
    public Developer(String name, int id, Manager manager) {
        super(name, id);
        this.manager = manager;
    }

    public void work() {
        System.out.println("Developer " + getName() + " is writing code.");
    }

    @Override
    public String toString() {
        return "Developer{" +
                "manager=" + manager.getName() +
                ", name='" + getName() + '\'' +
                ", id=" + getId() +
                '}';
    }
}

public class Q7 {

    // This is the employee and vehicle manager class


    public static void main(String[] args) {
        // Vehicles
        Car car1 = new Car("Toyota Camry", 50.0, "Sedan");
        Truck truck1 = new Truck("Ford F-150", 80.0, "ABC123");

        // Employees
        Manager manager1 = new Manager("Alice", 101, "IT");
        Developer developer1 = new Developer("Bob", 102, manager1);

        car1.drive();
        truck1.drive();
        manager1.work();
        System.out.println(manager1.toString());

        developer1.work();
        System.out.println(developer1.toString());

    }
    
}
