// In a company, the employee management system is designed to manage different
// types of employees, such as officers and managers. The system needs to store
// common details about employees like name, age, address, phone number, and salary,
// as well as specific details about officers and managers. Officers have a specialization
// field, and managers have a department field.
// Requirements:
    // 1. Common Employee Details:
    //  - The system should allow for retrieving and updating common details of
    // any employee.
    //  - There should be a method to calculate the annual salary of an employee.
    // 2. Officer Specific Details:
    //  - The system should manage the specialization field specific to officers.
    //  - There should be a method to calculate the salary of an officer, factoring in their
    // specialization.
    // 3. Manager Specific Details:
    //  - The system should manage the department field specific to managers.
    //  - There should be a method to calculate the salary of a manager, factoring in their
    // Department.

class Employee {
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private double salary;

    public Employee(String name, int age, String address, String phoneNumber, double salary) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double calculateAnnualSalary() {
        return salary * 12; // Assuming monthly salary
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class Officer extends Employee {
    private String specialization;

    public Officer(String name, int age, String address, String phoneNumber, double salary, String specialization) {
        super(name, age, address, phoneNumber, salary);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public double calculateAnnualSalary() {
        // Assuming specialization adds a 10% bonus to the salary
        return super.calculateAnnualSalary() * 1.10;
    }
}

class Manager extends Employee {
    private String department;

    public Manager(String name, int age, String address, String phoneNumber, double salary, String department) {
        super(name, age, address, phoneNumber, salary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public double calculateAnnualSalary() {
        // Assuming department adds a 15% bonus to the salary
        return super.calculateAnnualSalary() * 1.15;
    }
}


public class Q5 {
    public static void main(String[] args) {
        Officer officer = new Officer("Alice", 30, "123 Main St", "555-1234", 5000, "Software");
        Manager manager = new Manager("Bob", 40, "456 Elm St", "555-5678", 7000, "IT");

        System.out.println("Officer: " + officer.toString());
        System.out.println("Specialization: " + officer.getSpecialization());
        System.out.println("Annual Salary: " + officer.calculateAnnualSalary());

        System.out.println("\nManager: " + manager.toString());
        System.out.println("Department: " + manager.getDepartment());
        System.out.println("Annual Salary: " + manager.calculateAnnualSalary());
    }
    
}
