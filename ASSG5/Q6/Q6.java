// Write a java program to create a simple class hierarchy for a vehicle management system
// with two packages:
// - Package vehicles:
    // Class Vehicle:
        // -Field: licensePlate (String)
        // -Public method getLicensePlate() to return the license plate.
// - Package management:
    // Class Car (extends vehicles.Vehicle):
        // -Additional Field: model (String)
        // -Constructor to initialize all fields (using super for Vehicle fields)
        // -Public method getDetails() to return the license plate and model.

public class Q6 {
    public static void main(String[] args) {
        management.Car car1 = new management.Car("ABC123", "Toyota Camry");
        System.out.println("Car Details: " + car1.getDetails());
        System.out.println(car1.toString());

    }
}
