import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// Consider implementing a software/OS for a smart watch. It has to implement you types
// of functionalities pertaining to clock and fitness tracker. There are essential
// functionalities to be implemented associated with clock and fitness tracker. But the
// implementation of the clock and fitness tracker functionalities are specific to each smart
// watch. Clock functionalities should include showTime(), setAlarm() etc. Fitness tracker
// functionalities should include countSteps(), computeCaloriesBurned() etc.
// Hint: Use multiple inheritance in Java

interface ClockFeatures {
    void showTime();
    void setAlarm(String time24Hr);
}

interface FitnessFeatures {
    int countSteps();
    double computeCaloriesBurned(double weightInKg, int minutesWalked);
}

class SmartWatchOS implements ClockFeatures, FitnessFeatures {
    private String alarmTime;
    private int steps;

    public SmartWatchOS(int initialSteps) {
        this.steps = initialSteps;
    }

    @Override
    public void showTime() {
        String now = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("Current time: " + now);
    }

    @Override
    public void setAlarm(String time24Hr) {
        alarmTime = time24Hr;
        System.out.println("Alarm set for: " + alarmTime);
    }

    @Override
    public int countSteps() {
        return steps;
    }

    @Override
    public double computeCaloriesBurned(double weightInKg, int minutesWalked) {
        return (3.5 * weightInKg * minutesWalked) / 200.0;
    }

    public void addSteps(int newSteps) {
        if (newSteps > 0) {
            steps += newSteps;
        }
    }
}

public class Q5 {
    public static void main(String[] args) {
        SmartWatchOS watch = new SmartWatchOS(1200);

        watch.showTime();
        watch.setAlarm("06:30");
        watch.addSteps(2800);
        System.out.println("Total steps: " + watch.countSteps());
        System.out.println("Calories burned: " + watch.computeCaloriesBurned(70, 45));
    }
}
