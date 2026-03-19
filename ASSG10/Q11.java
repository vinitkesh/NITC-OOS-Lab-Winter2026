import java.util.Arrays;
import java.util.Comparator;

// Sort the students in ascending order of their ages using sorted() and
// Comparator.


public class Q11 {
    static class Student {
        private final String name;
        private final int age;

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        int getAge() {
            return age;
        }

        String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Asha", 19),
                new Student("Ravi", 20),
                new Student("Neha", 21),
                new Student("Arun", 22),
                new Student("Kiran", 20),
                new Student("Meera", 23),
                new Student("Vijay", 19),
                new Student("Diya", 21),
                new Student("Rahul", 24),
                new Student("Isha", 22)
        };

        Arrays.stream(students)
                .sorted(Comparator.comparingInt(Student::getAge))
                .forEach(student -> System.out.println(student.getName() + " - " + student.getAge()));
    }
}
