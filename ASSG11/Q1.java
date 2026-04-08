// 1. Given a list of Employee objects, use filter and map to find all in the "IT" department and
// return a list of their salaries increased by 10%.

class Employee {
    String name;
    String department;
    double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Alice", "IT", 50000),
                new Employee("Bob", "HR", 45000),
                new Employee("Charlie", "IT", 55000),
                new Employee("David", "Finance", 60000),
                new Employee("Eve", "IT", 52000)
        };

        double[] increasedSalaries = java.util.Arrays.stream(employees)
                .filter(e -> e.getDepartment().equals("IT"))
                .mapToDouble(e -> e.getSalary() * 1.10)
                .toArray();

        for (double salary : increasedSalaries) {
            System.out.println(salary);
        }
    }
}