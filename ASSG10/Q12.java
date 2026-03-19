import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

// 12.Get the names of the students grouped by age using groupingBy


public class Q12 {
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

        Map<Integer, List<String>> namesByAge = Arrays.stream(students)
                .collect(Collectors.groupingBy(
                        Student::getAge,
                        TreeMap::new,
                        Collectors.mapping(Student::getName, Collectors.toList())
                ));

        namesByAge.forEach((age, names) -> System.out.println(age + " -> " + names));
    }
}
