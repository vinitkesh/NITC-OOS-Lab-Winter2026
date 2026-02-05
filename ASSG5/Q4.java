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





class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }

    public void printName() {
        System.out.println("Manager's name: " + name);
    }
}