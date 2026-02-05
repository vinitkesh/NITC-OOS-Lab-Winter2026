import java.util.ArrayList;

// Description:
// Create a program for a university management system. The program should have the following
// classes:
    // - University
    // - Department
    // - Professor
    // - Student
// Requirements:
    // 1. The University class should contain a list of departments.
    // 2. The Department class should contain a list of professors and a list of students.
    // 3. The Professor class should contain information about the professor (e.g., name, id,
    // department).
    // 4. The Student class should contain information about the student (e.g., name, id, major).
// Tasks:
    // 1. Create instances of University, Department, Professor, and Student.
    // 2. Populate the university with departments, professors, and students.
    // 3. Display the details of the university, including its departments, 
    //  professors, and students



class University{
    ArrayList<Department> departments;

    public University() {
        this.departments = new ArrayList<>();
    }

    public University(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

}

class Department{
    ArrayList<Professor> professors;
    ArrayList<Student> students;

    public Department() {
        this.professors = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public Department(ArrayList<Professor> professors, ArrayList<Student> students) {
        this.professors = professors;
        this.students = students;
    }

    public void addProfessor(Professor professor) {
        this.professors.add(professor);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }


}

class Professor{
    String name;
    String id;
    String department;

    public Professor(String name, String id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

}

class Student{
    String name;
    String id;
    String major;

    public Student(String name, String id, String major) {
        this.name = name;
        this.id = id;
        this.major = major;
    }

}

public class Q1 {
    public static void main(String[] args) {
        // Create instances and populate the university management system here

        Student student1 = new Student("Alice", "S001", "Computer Science");
        Student student2 = new Student("Bob", "S002", "Mathematics");
        Professor professor1 = new Professor("Dr. Smith", "P001", "Computer Science");
        Department department1 = new Department();
        department1.addProfessor(professor1);
        department1.addStudent(student1);
        department1.addStudent(student2);
        University university = new University();
        university.addDepartment(department1);

        // Display details
        for (Department dept : university.departments) {
            System.out.println("Department:");
            System.out.println("Professors:");
            for (Professor prof : dept.professors) {
                System.out.println("Name: " + prof.name + ", ID: " + prof.id + ", Department: " + prof.department);
            }
            System.out.println("Students:");
            for (Student stud : dept.students) {
                System.out.println("Name: " + stud.name + ", ID: " + stud.id + ", Major: " + stud.major);
            }
        }

        
    }
}