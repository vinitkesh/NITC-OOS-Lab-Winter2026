// Write a Java program to demonstrate how access specifiers affect access from different
// packages. Create two packages: company and department. In the company package, define
// the following classes:
// Employee - A class with:
    // - Protected field name (String)
    // - Public method getName() to get the name.
// Manager - A subclass of Employee with:
    // - Public method printName() to print the name.
// In the department package, define a class Office which tries to access and print the name field
// from an Employee instance and show how the name field can be accessed and modified in the
// Manager class

import company.Employee;
import company.Manager;
import department.Office;

public class Q4 {

    public static void main(String[] args) {
        // Create an Employee instance
        Employee emp = new Employee("Alice");

        // Accessing name via public method (allowed)
        System.out.println("Employee name: " + emp.getName());

        // Create a Manager instance
        Manager mgr = new Manager("Bob");

        // Accessing name via subclass method (allowed)
        mgr.printName();

        // Modifying name via subclass method (allowed)
        mgr.changeName("Robert");
        mgr.printName();

         // Accessing name directly from Office class (not allowed, will cause compile error)
         // System.out.println("Employee name from Office: " + emp.name); // Uncommenting this line will cause an error
    }
}