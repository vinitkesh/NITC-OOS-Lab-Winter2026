// 4. Use filter and findFirst on a list of Student objects to find the first student with a grade
// over 90 whose name starts with 'Z', or return a default object.

import java.util.Arrays;
import java.util.Optional;

public class Q4 {
    static class Student {
        private final String name;
        private final int grade;

        Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public int getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', grade=" + grade + '}';
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Alice", 85),
                new Student("Bob", 92),
                new Student("Charlie", 88),
                new Student("Zara", 95),
                new Student("David", 90)
        };

        Optional<Student> studentOpt = Arrays.stream(students)
                .filter(s -> s.getGrade() > 90 && s.getName().startsWith("Z"))
                .findFirst();

        Student result = studentOpt.orElse(new Student("Default Student", 0));
        System.out.println(result);
    }
}