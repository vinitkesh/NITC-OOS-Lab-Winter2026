// In a company, There are 2 types of employees: workers and managers. They have
// different base salaries. The base pay calculation of all the employees is the same. It is
// pay= base salary - (base salary * 0.2). For managers the performance bonus has to be
// added to this pay. The same function should return the final salary for all employee
// types. Design Java classes in such a way that base pay calculation logic should not be
// duplicated.
// Hint: Do not use abstract class or interface.

class Employee {
    protected double baseSalary;

    public Employee(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double calculatePay() {
        return baseSalary - (baseSalary * 0.2);
    }
}

class Worker extends Employee {
    public Worker(double baseSalary) {
        super(baseSalary);
    }
}

class Manager extends Employee {
    private double performanceBonus;

    public Manager(double baseSalary, double performanceBonus) {
        super(baseSalary);
        this.performanceBonus = performanceBonus;
    }

    @Override
    public double calculatePay() {
        return super.calculatePay() + performanceBonus;
    }
}


public class Q1 {
    public static void main(String[] args) {
        Employee worker = new Worker(50000);
        Employee manager = new Manager(70000, 10000);

        System.out.println("Worker's pay: " + worker.calculatePay());
        System.out.println("Manager's pay: " + manager.calculatePay());
    }
}
