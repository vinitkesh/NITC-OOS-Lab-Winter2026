import java.util.Arrays;

// Define a Student class with name and age. You have an array of 10 student
// instances. Get the average age of the students using the same code pattern in
// the previous code.

public class Q10 {
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

        double averageAge = Arrays.stream(students)
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);

        System.out.printf("Average age: %.2f%n", averageAge);
    }
}
