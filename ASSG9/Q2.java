// Write a java program to create a software solution to manage different types of
// electronic devices in a store. The store sells various electronic devices, and each
// device has different functionalities, like powering on and connecting to a network.
// Implement the following requirements:
// a. Interface PoweredDevice: represents any device that requires power to function. This
// interface should have methods powerOn() to power on the device and powerOff() to
// power off the device.
// b. Interface NetworkEnabled represents any device that can connect to a network. This
// interface should have methods connectToNetwork(String networkName) to connect the
// device to a specified network and disconnectFromNetwork() to disconnect the device
// from the network.
// c. Class SmartPhone: class should implement both the PoweredDevice and
// NetworkEnabled interfaces. It should have attributes model to store the model name,
// isPoweredOn to indicate if the phone is powered on, connectedNetwork to store the
// name of the connected network. This class must implement all the methods in the
// PoweredDevice and NetworkEnabled interface and must contain a toString() method to
// return a string representation of the phone's model, power state, and connected network
// (if any).
// d. Write a main method that simulates the usage of a SmartPhone in the store. In this
// method, create an instance of SmartPhone with a sample model name. Then call the
// powerOn(), connectToNetwork(), and disconnectFromNetwork() methods in sequence to
// demonstrate the device's capabilities. Finally, use the toString() method to print out the
// phone's details, verifying that the software solution is ready to help manage the store's
// inventory of electronic devices effectively.


interface PoweredDevice {
    void powerOn();
    void powerOff();
}

interface NetworkEnabled {
    void connectToNetwork(String networkName);
    void disconnectFromNetwork();
}

class SmartPhone implements PoweredDevice, NetworkEnabled {
    private String model;
    private boolean isPoweredOn;
    private String connectedNetwork;

    public SmartPhone(String model) {
        this.model = model;
        this.isPoweredOn = false;
        this.connectedNetwork = null;
    }

    public void powerOn() {
        isPoweredOn = true;
        System.out.println(model + " is powered on.");
    }

    public void powerOff() {
        isPoweredOn = false;
        connectedNetwork = null; // Disconnect from network when powered off
        System.out.println(model + " is powered off.");
    }

    public void connectToNetwork(String networkName) {
        if (isPoweredOn) {
            connectedNetwork = networkName;
            System.out.println(model + " is connected to " + networkName + ".");
        } else {
            System.out.println(model + " cannot connect to a network while powered off.");
        }
    }

    public void disconnectFromNetwork() {
        if (connectedNetwork != null) {
            System.out.println(model + " is disconnected from " + connectedNetwork + ".");
            connectedNetwork = null;
        } else {
            System.out.println(model + " is not connected to any network.");
        }
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "model='" + model + '\'' +
                ", isPoweredOn=" + isPoweredOn +
                ", connectedNetwork='" + (connectedNetwork != null ? connectedNetwork : "None") + '\'' +
                '}';
    }
}


public class Q2 {
    public static void main(String[] args) {

        SmartPhone phone = new SmartPhone("Galaxy S21");
        phone.powerOn();
        phone.connectToNetwork("Home WiFi");
        System.out.println(phone.toString());
        phone.disconnectFromNetwork();
        phone.powerOff();
        System.out.println(phone.toString());
    }
}
