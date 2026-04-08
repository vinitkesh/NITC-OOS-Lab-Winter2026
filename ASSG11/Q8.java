// 8. Use partitioningBy to split a list of ExamResult objects into a Map<Boolean,
// List<ExamResult>> based on whether their score is >= 50.

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ExamResult {
    private final String studentName;
    private final int score;

    public ExamResult(String studentName, int score) {
        this.studentName = studentName;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "ExamResult{studentName='" + studentName + "', score=" + score + '}';
    }
}

public class Q8 {
    public static void main(String[] args) {
        ExamResult[] results = {
                new ExamResult("Alice", 85),
                new ExamResult("Bob", 45),
                new ExamResult("Charlie", 60),
                new ExamResult("David", 30),
                new ExamResult("Eve", 75)
        };

        Map<Boolean, List<ExamResult>> partitionedResults = Arrays.stream(results)
                .collect(Collectors.partitioningBy(r -> r.getScore() >= 50));

        partitionedResults.forEach((passed, examResults) -> {
            System.out.println(passed ? "Passed:" : "Failed:");
            examResults.forEach(System.out::println);
        });
    }
}