// You are given the task of implementing a logging system for Java applications.
// Implement a Logger class incorporating singleton pattern for instance creation.
// Implement logging of warning, error and fatal based on the flag set by the application
// developer. The flag can be set values to indicate different levels of logging. 

class Logger {
    private static Logger instance;
    private int logLevel;

    private Logger() {
        // Private constructor to prevent instantiation
        this.logLevel = 0; // Default log level
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public boolean log(String message, int level) {
        if (logLevel <= level) {
            System.out.println(message);
            return true;
        }
        else if(level == 1) {
            logWarning(message);
        }
        else if(level == 2) {
            logError(message);
        }
        else if(level == 3) {
            logFatal(message);
        }
        return false;
    }

    public void logWarning(String message) {
        if (logLevel <= 1) {
            System.out.println("WARNING: " + message);
        }
    }

    public void logError(String message) {
        if (logLevel <= 2) {
            System.out.println("ERROR: " + message);
        }
    }

    public void logFatal(String message) {
        if (logLevel <= 3) {
            System.out.println("FATAL: " + message);
        }
    }
}

public class Q1 {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.log("Custom warning message.", 1);
        logger.log("Custom error message.", 2);
        logger.log("Custom fatal message.", 3);

        logger.log("This warning will not be logged.", 1);
        logger.log("Another custom error message.", 2);
        logger.log("Another custom fatal message.", 3);

        logger.log("This custom warning will not be logged.", 1);
        logger.log("This custom error will not be logged.", 2);
        logger.log("This is yet another custom fatal message.", 3);
    }
}
