
import java.util.PriorityQueue;

// Create a patient management system for a hospital emergency room using a
// PriorityQueue. 

// Design a Patient class with attributes: name (String), age (int), ailment
// (String), and priority (int) where 1=Critical, 2=Serious, 3=Moderate, 4=Minor, and
// 5=Non-urgent. 
// Implement a HospitalEmergencyRoom class that uses a
// PriorityQueue<Patient> with a custom Comparator to ensure patients with lower priority
// numbers are treated first. If two patients have the same priority level, they should be
// treated in the order they arrived (FIFO). The class should include methods to add
// patients, treat the next patient (remove and return), display all waiting patients, and get
// the count of waiting patients. In the Main class, demonstrate the system by creating 6-8
// patients with different priority levels, adding them in random order, displaying the waiting
// list, treating several patients, and showing the updated queue after each treatment to
// prove that patients are being treated by priority rather than arrival order.
// Hint: Use Comparator and override the compare() method

class Patient {
    String name;
    int age;
    String ailment;
    int priority; // 1=Critical, 2=Serious, 3=Moderate, 4=Minor, 5=Non-urgent
    int arrivalCounter; // To maintain the order of arrival for patients with the same priority

    public Patient(String name, int age, String ailment, int priority) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Patient{name='" + name + "', age=" + age + ", ailment='" + ailment + "', priority=" + priority + "}";
    }
}

class HospitalEmergencyRoom {
    private PriorityQueue<Patient> patients;
    private int arrivalCounter; // To maintain the order of arrival for patients with the same priority

    public HospitalEmergencyRoom() {
        // Custom comparator to sort patients by priority and then by arrival order
        this.arrivalCounter = 0;
        this.patients = new PriorityQueue<>((p1, p2) -> {
            if (p1.priority != p2.priority) {
                return Integer.compare(p1.priority, p2.priority); // Lower priority number first
            } else {
                return Integer.compare(p1.arrivalCounter, p2.arrivalCounter); // If priorities are the same, maintain insertion order (FIFO)
            }
        });
    }

    public void addPatient(Patient patient) {
        // Add patient to the priority queue
        patient.arrivalCounter = arrivalCounter++;
        patients.add(patient);
    }

    public Patient treatNextPatient() {
        // Remove and return the next patient in priority order
        return patients.poll();
    }

    public void displayWaitingPatients() {
        // Display all waiting patients
        System.out.println("Waiting Patients:");
        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    public int getWaitingPatientsCount() {
        // Return the count of waiting patients
        return patients.size();
    }
}

public class Q6 {
    public static void main(String[] args) {
        HospitalEmergencyRoom emergencyRoom = new HospitalEmergencyRoom();

        // Create patients with different priority levels
        Patient patient1 = new Patient("Alice", 30, "Fracture", 2);
        Patient patient2 = new Patient("Bob", 25, "Headache", 4);
        Patient patient3_0 = new Patient("Moses", 40, "Heart Attack", 1);
        Patient patient3 = new Patient("Charlie", 40, "Heart Attack", 1);
        Patient patient4 = new Patient("David", 35, "Flu", 5);
        Patient patient5 = new Patient("Eve", 28, "Burns", 3);
        Patient patient6 = new Patient("Frank", 50, "Stroke", 1);
        Patient patient7 = new Patient("Grace", 22, "Allergy", 4);

        // Add patients to the emergency room
        emergencyRoom.addPatient(patient1);
        emergencyRoom.addPatient(patient2);
        emergencyRoom.addPatient(patient3_0);
        emergencyRoom.addPatient(patient3);
        emergencyRoom.addPatient(patient4);
        emergencyRoom.addPatient(patient5);
        emergencyRoom.addPatient(patient6);
        emergencyRoom.addPatient(patient7);

        // Display waiting patients
        emergencyRoom.displayWaitingPatients();

        while (emergencyRoom.getWaitingPatientsCount() > 0) {
            // Treat the next patient and display the updated queue
            Patient treatedPatient = emergencyRoom.treatNextPatient();
            System.out.println("\nTreated Patient: " + treatedPatient);
            // emergencyRoom.displayWaitingPatients();
        }
    }
}

