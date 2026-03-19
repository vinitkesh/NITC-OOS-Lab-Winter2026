import java.util.Arrays;
import java.util.Optional;

public class Q14 {
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

        Optional<Student> oldest = Arrays.stream(students)
                .reduce((s1, s2) -> s1.getAge() >= s2.getAge() ? s1 : s2);

        oldest.ifPresent(student ->
                System.out.println("Oldest student: " + student.getName() + " (" + student.getAge() + ")")
        );
    }
}
