
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Simple {
    public static void main(String[] args) {
        List<String> words = List.of("Apple", "Banana", "Avocado", "Cherry", "Apricot");

        // Q1
        words.forEach(word -> System.out.println(word));
        System.out.println("");

        // Q2
        words.forEach(System.out::println);
        System.out.println("");

        // Q4
        List<String> upperCaseWords = words.stream().map(String::toUpperCase).toList();
        upperCaseWords.forEach(System.out::println);
        System.out.println("");

        // Q5
        List<Integer> charCount = words.stream().map(String::length).toList();
        charCount.forEach(System.out::println);
        System.out.println("");

        // Q6
        List<String> startsWithA = words.stream().filter(word -> word.startsWith("A")).toList();
        startsWithA.forEach(System.out::println);
        System.out.println("");

        // Q7 Modify the above program with collect() to get the words starting with ‘A’ to an assigned variable array.
        List<String> aWordsList = words.stream()
                                        .filter(word -> word.startsWith("A"))
                                        .collect(Collectors.toList());
        String[] aWordsArray = aWordsList.toArray(new String[0]);
        System.out.println("");

        // Q8 Using predicate

        Predicate<String> checkStartWithA = word -> word.startsWith("A");
        String[] filteredWords = words.stream()
                                      .filter(checkStartWithA)
                                      .toArray(String[]::new);
        System.out.println("Words starting with 'A':");
        for (String word : filteredWords) {
            System.out.println(word);
        }
        System.out.println("");

        // Q9 Sum of chars in list using streamand mpToInt
        int totalChars = words.stream()
                              .mapToInt(String::length)
                              .sum();
        System.out.println("Total number of characters in the list: " + totalChars +"\n");

        // Q10
        class Student{
            String name;
            int age;

            Student(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }
        }

        List<Student> students = List.of(
                new Student("Alice", 20),
                new Student("Bob", 22),
                new Student("Charlie", 20),
                new Student("David", 23)
        );

        Double avgAge = students.stream()
                                    .mapToInt(Student::getAge)
                                    .average()
                                    .orElse(0.0);

        System.out.printf("Average age of students: %.2f%n", avgAge);

        // Q11 Sort students in asc
        List<Student> sortedStudents = students.stream()
                                               .sorted((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()))
                                               .toList();

        System.out.println("Students sorted by age:");
        sortedStudents.forEach(student -> System.out.println(student.getName() + " - " + student.getAge()));

        // Q12 studnets grouped by ages using groupingBy
        var groupedByAge = students.stream()
                                    .collect(Collectors.groupingBy(Student::getAge));

        // Q14 oldest student using reduce

        Student oldestStudent = students.stream()
                                        .reduce((s1, s2) -> s1.getAge() > s2.getAge() ? s1 : s2)
                                        .orElse(null);

        System.out.println("Oldest student: " + oldestStudent.getName() + " - " + oldestStudent.getAge());

    }
}
