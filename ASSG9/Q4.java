import java.time.LocalDate;
import java.util.Iterator;

class DateRange implements Iterable<LocalDate> {
    private final LocalDate start, end;

    DateRange(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<LocalDate> iterator() {
        return new Iterator<>() {
            private LocalDate current = start;

            @Override
            public boolean hasNext() {
                return !current.isAfter(end);
            }

            @Override
            public LocalDate next() {
                LocalDate date = current;
                current = current.plusDays(1);
                return date;
            }
        };
    }
}

public class Q4 {
    public static void main(String[] args) {
        DateRange range = new DateRange(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 7));
        for (LocalDate date : range) {
            System.out.println(date); // prints Jan 1 through Jan 7
        }
    }
}
