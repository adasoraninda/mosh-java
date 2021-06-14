package collections;

import java.util.Queue;
import java.util.ArrayDeque;

public class QueueDemo {
    public static void show() {
        Queue<String> queue = new ArrayDeque<String>();

        queue.add("c");
        queue.add("a");
        queue.add("b");
        // queue.offer("d");
        // d -> b -> a -> c
        // b -> a -> c
        var front = queue.peek(); // c
        System.out.println(front);
    }
}
