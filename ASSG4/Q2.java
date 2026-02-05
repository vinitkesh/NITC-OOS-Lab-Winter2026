// Implement the functions registerStudent(), getWaitlistPosition() and removeStudent().
// An id once added should not get added again. The order in which the registrations are
// done is to be preserved without storing any additional information.
// Hint: use LinkedHashSet

import java.util.Iterator;
import java.util.LinkedHashSet;


class CourseRegistration{
    private String courseCode;
    private final LinkedHashSet<Student> registeredStudents;

    public CourseRegistration(String courseCode) {
        this.courseCode = courseCode;
        this.registeredStudents = new LinkedHashSet<>();
    }

    public boolean registerStudent(Student student) {
        return registeredStudents.add(student);
    }

    public int getWaitlistPosition(String studentId) {
        int position = 1;
        for (Student s : registeredStudents) {
            if (s.getId().equals(studentId)) {
                return position;
            }
            position++;
        }
        return -1; // Not found
    }

    public void removeStudent(String studentId) {
        Iterator<Student> iterator = registeredStudents.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getId().equals(studentId)) {
                iterator.remove();
                return;
            }
        }
    }

    public void displayRegistrationOrder() {
        int position = 1;
        for (Student s : registeredStudents) {
            System.out.println(position + ". " + s.getName() + " (" + s.getId() + ") - " + s.getEmail());
            position++;
        }
    }
}

class Student{
    private final String id;
    private final String name;
    private final String email;

    public Student(String id, String name, String email) {
        if (id == null || name == null || email == null) {
            throw new IllegalArgumentException("Student details cannot be null");
        }
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

public class Q2 {
    public static void main(String[] args) {
        CourseRegistration course = new CourseRegistration("CS101");
        Student s1 = new Student("S001", "Alice", "alice@uni.edu");
        Student s2 = new Student("S002", "Bob", "bob@uni.edu");
        Student s3 = new Student("S003", "Charlie", "charlie@uni.edu");
        Student s4 = new Student("S001", "Alice Smith", "newemail@uni.edu"); // Same ID as s1
        
        course.registerStudent(s1); // true
        course.registerStudent(s2); // true
        course.registerStudent(s3); // true
        course.registerStudent(s4); // false (duplicate ID)
        
        course.displayRegistrationOrder();
        // Output:
        // 1. Alice (S001) - alice@uni.edu
        // 2. Bob (S002) - bob@uni.edu
        // 3. Charlie (S003) - charlie@uni.edu
        System.out.println(course.getWaitlistPosition("S002")); //
        // Output: 2
        course.removeStudent("S002");
        System.out.println(course.getWaitlistPosition("S003")); //
        // Output: 2 (moved up)
    }
}