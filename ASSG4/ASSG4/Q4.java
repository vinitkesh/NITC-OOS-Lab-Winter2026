// Write a java program to implement a Task Manager which uses a priority queue to
// manage a collection of tasks, each with a priority level. Task Manager should be able to
// perform the following operations:
    // 1. addTask(): add tasks to the priority queue.
    // 2. processTask(): process task will process the task and remove task based on their
    // priority.
    // 3. displayTask(): display the current task in the queue.
    // 4. exit( ): exit from the program
// In the main method, create an instance of your TaskManager class and demonstrate the
// use of the methods by performing the following operation which is mentioned above.
// Input/Output Format:
    // Select the operation:
    // 1
    // Add Task with their priority and description
    // 1, Meeting at 2pm
    // Select the operation:
    // 1
    // Add Task with their priority and description
    // 2, Buy groceries
    // Select the operation:
    // 2
    // Select the operation:
    // 3

class Task implements Comparable<Task>{
    private final int priority;
    private final String description;

    public Task(int priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }
}


public class Q4 {
    private final java.util.PriorityQueue<Task> taskQueue;

    public Q4() {
        taskQueue = new java.util.PriorityQueue<>();
    }

    public void addTask(int priority, String description) {
        Task newTask = new Task(priority, description);
        taskQueue.add(newTask);
        System.out.println("Task added: " + description + " with priority " + priority);
    }

    public void processTask() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks to process.");
            return;
        }
        Task task = taskQueue.poll();
        System.out.println("Processing task: " + task.getDescription() + " with priority " + task.getPriority());
    }

    public void displayTasks() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks in the queue.");
            return;
        }
        System.out.println("Current tasks in the queue:");
        for (Task task : taskQueue) {
            System.out.println("Priority: " + task.getPriority() + ", Description: " + task.getDescription());
        }
    }

    public static void main(String[] args) {
        Q4 taskManager = new Q4();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSelect the operation:");
            System.out.println("1. Add Task");
            System.out.println("2. Process Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Add Task with their priority and description (format: priority, description):");
                    String input = scanner.nextLine();
                    String[] parts = input.split(",", 2);
                    int priority = Integer.parseInt(parts[0].trim());
                    String description = parts[1].trim();
                    taskManager.addTask(priority, description);
                    break;
                case 2:
                    taskManager.processTask();
                    break;
                case 3:
                    taskManager.displayTasks();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}