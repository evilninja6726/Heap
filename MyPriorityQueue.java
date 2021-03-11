package heapDs;

import java.util.Collections;
import java.util.PriorityQueue;

public class MyPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> minPriorityQueue=new PriorityQueue<>();
        minPriorityQueue.add(4);
        minPriorityQueue.add(1);
        minPriorityQueue.add(7);
        minPriorityQueue.add(8);
        minPriorityQueue.add(2);
        System.out.println(minPriorityQueue.peek());
        System.out.println(minPriorityQueue.poll());
        System.out.println(minPriorityQueue.peek());

        PriorityQueue<Integer> maxPriorityQueue=new PriorityQueue<>(Collections.reverseOrder());
        maxPriorityQueue.add(4);
        maxPriorityQueue.add(1);
        maxPriorityQueue.add(7);
        maxPriorityQueue.add(8);
        maxPriorityQueue.add(2);
        System.out.println(maxPriorityQueue.peek());
        System.out.println(maxPriorityQueue.poll());
        System.out.println(maxPriorityQueue.peek());
    }
}
