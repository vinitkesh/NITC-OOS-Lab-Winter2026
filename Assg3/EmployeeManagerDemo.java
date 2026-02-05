import java.util.HashSet;
import java.util.Scanner;

class EmployeeManager {
    HashSet<Integer> employeeIds = new HashSet<>();

    void addEmployeeId(int id) {
        if (employeeIds.add(id)) {
            System.out.println("Employee ID added");
        } else {
            System.out.println("Duplicate Employee ID");
        }
    }

    void removeEmployeeId(int id) {
        if (employeeIds.remove(id)) {
            System.out.println("Employee ID removed");
        } else {
            System.out.println("Employee ID not found");
        }
    }

    void displayEmployeeIds() {
        if (employeeIds.isEmpty()) {
            System.out.println("No Employee IDs available");
        } else {
            for (int id : employeeIds) {
                System.out.println(id);
            }
        }
    }
}

public class EmployeeManagerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        while (true) {
            System.out.println("\n1.Add 2.Remove 3.Display 4.Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    manager.addEmployeeId(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter Employee ID: ");
                    manager.removeEmployeeId(sc.nextInt());
                    break;
                case 3:
                    manager.displayEmployeeIds();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
