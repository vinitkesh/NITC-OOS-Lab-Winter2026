package department;

import company.Employee;
import company.Manager;

public class Office {

    public static void main(String[] args) {

        Employee emp = new Employee("Alice");

        System.out.println("Employee name: " + emp.getName());

        Manager mgr = new Manager("Bob");

        mgr.printName();

        // ✔ Modify protected field via subclass method
        mgr.changeName("Robert");
        mgr.printName();
    }
}
