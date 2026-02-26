// Consider a scenario where you have a base class called Employee, and two derived
// classes called Manager and Developer. The Manager class should have an additional
// attribute called departmentName, and the Developer class should have an additional
// attribute called programmingLanguage.
    // - Define the Employee class with attributes name and salary, add a method
    //   abstract method displayDetails() that prints the details of the employee, add set
    //   and get methods for the attributes, add a method computeIncomeTax() which
    //   computes 10% of the salary as income tax.
    // - Define the Manager class that extends the Employee class, and include the
    //   departmentName attribute. Override the displayDetails() method to include the
    //   department name.
    // - Define the Developer class that extends the Employee class, and include the
    //   programmingLanguage attribute. Override the displayDetails() method to include
    //   the programming language.
    // - Create instances of Manager and Developer, and demonstrate the use of the
    //   displayDetails() method.


abstract class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // abstract method to display details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }

    // method to compute income tax
    public double computeIncomeTax() {
        return salary * 0.10; // 10% of the salary as income tax
    }
}

class Manager extends Employee {
    String departmentName;

    public Manager(String name, double salary, String departmentName) {
        super(name, salary);
        this.departmentName = departmentName;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Department Name: " + this.departmentName);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    public Developer(String name, double salary, String programmingLanguage) {
        super(name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + this.programmingLanguage);
    }
}

public class Q3 {
    public static void main(String[] args) {
        Employee manager = new Manager("Alice", 70000, "Engineering");
        Employee developer = new Developer("Bob", 60000, "Java");

        manager.displayDetails();
        System.out.println("Income Tax: " + manager.computeIncomeTax());

        developer.displayDetails();
        System.out.println("Income Tax: " + developer.computeIncomeTax());
    }
}
