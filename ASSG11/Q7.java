// 7. Use mapToInt and summaryStatistics on an array of Transaction objects to print the
// count, sum, min, max, and average of all amounts in one statement.
class Transaction {
    private final String id;
    private final double amount;

    public Transaction(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

public class Q7 {
    public static void main(String[] args) {
        Transaction[] transactions = {
                new Transaction("T1", 100.0),
                new Transaction("T2", 150.0),
                new Transaction("T3", 200.0),
                new Transaction("T4", 50.0),
                new Transaction("T5", 300.0)
        };

        java.util.IntSummaryStatistics stats = java.util.Arrays.stream(transactions)
                .mapToInt(t -> (int) t.getAmount())
                .summaryStatistics();

        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Average: " + stats.getAverage());
    }
}
