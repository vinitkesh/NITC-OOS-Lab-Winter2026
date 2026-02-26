// You are working on a travel booking application where users can book different types of
// transportation for their journey. The application should handle:
// 1. Booking a flight: The user provides the flight number, departure city, and arrival city.
// 2. Booking a train: The user provides the train number and the class of service (e.g.,
// economy, business).
// 3. Booking a cab: The user provides the pickup location and destination, with an option
// to specify the number of passengers.
// Implement a method bookTransport() using method overloading to handle the following
// scenarios:
    // - Book a flight by providing the flight number, departure city, and arrival city.
    // - Book a train by providing the train number and class of service.
    // - Book a cab by providing the pickup location and destination, with an optional
// parameter for the number of passengers.

class TravelBooking {
    // Method to book a flight
    public void bookTransport(String flightNumber, String departureCity, String arrivalCity) {
        System.out.println("Booking flight: " + flightNumber + " from " + departureCity + " to " + arrivalCity);
    }

    // Method to book a train
    public void bookTransport(String trainNumber, String classOfService) {
        System.out.println("Booking train: " + trainNumber + " with class of service: " + classOfService);
    }

    // Method to book a cab
    public void bookTransport(String pickupLocation, String destination, int numberOfPassengers) {
        System.out.println("Booking cab from " + pickupLocation + " to " + destination + " for " + numberOfPassengers + " passengers.");
    }
}

public class Q5 {
    public static void main(String[] args) {
        TravelBooking travelBooking = new TravelBooking();

        // Book a flight
        travelBooking.bookTransport("AI-202", "New York", "London");

        // Book a train
        travelBooking.bookTransport("12345", "Economy");

        // Book a cab
        travelBooking.bookTransport("Downtown", "Airport", 3);
    }
}

