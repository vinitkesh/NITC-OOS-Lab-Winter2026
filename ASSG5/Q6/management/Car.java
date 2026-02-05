package management;
import vehicles.Vehicle;

public class Car extends Vehicle {
    private String model;
    
    public Car(String licensePlate, String model) {
        super(licensePlate);
        this.model = model; 
    }

    public String getDetails() {
        return "License Plate: " + getLicensePlate() + ", Model: " + model;
    }
    
    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + getLicensePlate() + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}