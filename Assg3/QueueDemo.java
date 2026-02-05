import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class MyQueue {
    Queue<Integer> queue = new LinkedList<>();

    public void enqueue(int value) {
        queue.add(value);
        System.out.println("Success");
    }

    public void dequeue() {
        if (queue.isEmpty()) {
            System.out.println("EmptyQueue");
        } else {
            System.out.println(queue.remove());
        }
    }
}

public class QueueDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyQueue q = new MyQueue();

        while (sc.hasNext()) {
            String op = sc.next();

            if (op.equalsIgnoreCase("E")) {
                int value = sc.nextInt();
                q.enqueue(value);
            } else if (op.equalsIgnoreCase("D")) {
                q.dequeue();
            }
        }
        sc.close();
    }
}
