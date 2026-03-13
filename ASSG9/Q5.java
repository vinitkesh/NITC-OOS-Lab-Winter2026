import java.util.*;

interface VoiceControllable {
    void executeCommand(String command);
    void onVoiceCommand(String phrase);
}

interface Schedulable {
    void turnOn();
    void turnOff();
    void schedule(String cronExpression);
    void scheduleOnAt(int hour);
}

interface EnergyMonitorable {
    double getWattsConsumed();
    String getEnergyReport();
    boolean isHighConsumer(double thresholdWatts);
}

interface WiFiConnectable {
    String getDeviceId();
    void connect(String ssid);
    void disconnect();
    boolean isOnline();
}

class SmartBulb implements VoiceControllable, Schedulable, WiFiConnectable {
    private String id;
    private boolean on;

    public SmartBulb(String id) {
        this.id = id;
        this.on = false;
    }

    public String getDeviceId() {
        return id;
    }

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    public void executeCommand(String command) {
        // Implementation here
    }

    public void onVoiceCommand(String phrase) {
        if (phrase.toLowerCase().contains("on") || phrase.toLowerCase().contains("start")) {
            turnOn();
        } else if (phrase.toLowerCase().contains("off") || phrase.toLowerCase().contains("stop")) {
            turnOff();
        }
    }

    public void schedule(String cronExpression) {
        // Implementation here
    }

    public void scheduleOnAt(int hour) {
        // Implementation here
    }

    public void connect(String ssid) {
        // Implementation here
    }

    public void disconnect() {
        // Implementation here
    }

    public boolean isOnline() {
        return true;
    }
}

class SmartAC implements VoiceControllable, Schedulable, EnergyMonitorable, WiFiConnectable {
    private String id;
    private boolean on;
    private int temperature;

    public SmartAC(String id) {
        this.id = id;
        this.on = false;
        this.temperature = 24;
    }

    public String getDeviceId() {
        return id;
    }

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    public double getWattsConsumed() {
        return 1500.0; // Example value
    }

    public void executeCommand(String command) {
        // Implementation here
    }
    public void onVoiceCommand(String phrase) {
        if (phrase.toLowerCase().contains("on") || phrase.toLowerCase().contains("start")) {
            turnOn();
        } else if (phrase.toLowerCase().contains("off") || phrase.toLowerCase().contains("stop")) {
            turnOff();
        } else if (phrase.toLowerCase().contains("temperature")) {
            // Extract temperature from phrase and set it
        }
    }
    public void schedule(String cronExpression) {
        // Implementation here
    }

    public void scheduleOnAt(int hour) {
        // Implementation here
    }

    public String getEnergyReport() {
        return "Energy report for AC";
    }

    public boolean isHighConsumer(double thresholdWatts) {
        return getWattsConsumed() > thresholdWatts;
    }

    public void connect(String ssid) {
        // Implementation here
    }

    public void disconnect() {
        // Implementation here
    }

    public boolean isOnline() {
        return true;
    }
}

class SmartPlug implements EnergyMonitorable, WiFiConnectable {
    private String id;
    private double load;

    public SmartPlug(String id, double load) {
        this.id = id;
        this.load = load;
    }

    public String getDeviceId() {
        return id;
    }

    public double getWattsConsumed() {
        return load;
    }

    public String getEnergyReport() {
        return "Energy report for Plug";
    }

    public boolean isHighConsumer(double thresholdWatts) {
        return load > thresholdWatts;
    }

    public void connect(String ssid) {
        // Implementation here
    }

    public void disconnect() {
        // Implementation here
    }

    public boolean isOnline() {
        return true;
    }
}

class SmartHomeHub implements WiFiConnectable {
    private String id;
    private boolean online;

    public SmartHomeHub(String id) {
        this.id = id;
        this.online = true;
    }

    public String getDeviceId() {
        return id;
    }

    public void connect(String ssid) {
        // Implementation here
    }

    public void disconnect() {
        // Implementation here
    }

    public boolean isOnline() {
        return online;
    }

    public void reconnectAll(List<WiFiConnectable> devices, String ssid) {
        for (WiFiConnectable device : devices) {
            device.connect(ssid);
        }
    }

    public void auditEnergy(List<EnergyMonitorable> devices) {
        for (EnergyMonitorable device : devices) {
            System.out.println(device.getEnergyReport());
        }
    }

    public void nightMode(List<Schedulable> devices) {
        for (Schedulable device : devices) {
            device.turnOff();
        }
    }
}

public class Q5 {
    public static void main(String[] args) {

        // demonstration of Smart Home Hub managing devices
        SmartHomeHub hub = new SmartHomeHub("Hub1");
        SmartBulb bulb = new SmartBulb("Bulb1");
        SmartAC ac = new SmartAC("AC1");
        SmartPlug plug = new SmartPlug("Plug1", 2000.0);
        List<WiFiConnectable> devices = Arrays.asList(bulb, ac, plug);
        hub.reconnectAll(devices, "Home WiFi");


        List<EnergyMonitorable> energyDevices = Arrays.asList(ac, plug);
        hub.auditEnergy(energyDevices);

        List<Schedulable> schedulableDevices = Arrays.asList(bulb, ac);
        hub.nightMode(schedulableDevices);

        
    }
}
