// public class LogisticsApp {
//     private String transportType;
//     public LogisticsApp(String type) {
//         this.transportType = type;
//     }
//     public void planDelivery() {
//         // PROBLEM 1: The App is "coupled" to concrete classes (Truck, Ship)
//         if (transportType.equalsIgnoreCase("Road")) {
//             Truck truck = new Truck();
//              // PROBLEM 2: Specific setup logic is mixed into the business logic
//             truck.checkTirePressure();
//             truck.fillDiesel();
//             truck.deliver();
//         }
//         else if (transportType.equalsIgnoreCase("Sea")) {
//             Ship ship = new Ship();
//             // PROBLEM 2: Different setup for different objects
//             ship.checkAnchor();
//             ship.loadContainers();
//             ship.deliver();
//         }
//          // PROBLEM 3: To add "Air" delivery, you MUST change this existing code!
//     }
// }


// Solution using Factory Method pattern:


class TransportFactory {
    public static Transport createTransport(String transportType) {
        if (transportType.equalsIgnoreCase("Road")) {
            return new Truck();
        } else if (transportType.equalsIgnoreCase("Sea")) {
            return new Ship();
        }
        // To add "Air" delivery, simply add another condition here without changing existing code
        return null;
    }
}

// Transport interface
interface Transport {
    void setup();
    void deliver();
}

class Truck implements Transport {
    @Override
    public void setup() {
        System.out.println("Checking tire pressure and filling diesel for Truck.");
    }
    @Override
    public void deliver() {
        System.out.println("Delivering by Truck.");
    }
}

class Ship implements Transport {
    @Override
    public void setup() {
        System.out.println("Checking anchor and loading containers for Ship.");
    }
    @Override
    public void deliver() {
        System.out.println("Delivering by Ship.");
    }
}

class LogisticsApp {
    private Transport transport;
    public LogisticsApp (String type) {
        this.transport = TransportFactory.createTransport(type);
    }
    public void planDelivery() {
        if (transport != null) {
            transport.setup();
            transport.deliver();
        } else {
            System.out.println("Invalid transport type.");
        }
    }

}

public class Q5 {
    public static void main(String[] args) {
        LogisticsApp logisticsApp = new LogisticsApp("Road");
        logisticsApp.planDelivery();

        LogisticsApp logisticsApp2 = new LogisticsApp("Sea");
        logisticsApp2.planDelivery();
    }
}