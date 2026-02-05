package management;
import vehicles.Vehicle;

public class Car extends Vehicle {
    private String licensePlate;
    
    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    @Override
    public String getLicensePlate() {
        return licensePlate;
    }
}