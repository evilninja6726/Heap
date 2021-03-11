package heapDs;

import java.util.PriorityQueue;

public class MaxItemWithSum {
    public static void main(String[] args) {
        System.out.println(maxItemWithSum(new int[]{4, 2, 5, 8, 11, 3, 1, 12}, 20));
    }

    public static int maxItemWithSum(int[] arr, int sum) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int x : arr)
            priorityQueue.add(x);
        int count = 0;
        while (sum >= priorityQueue.peek()) {
            sum -= priorityQueue.poll();
            count++;
        }
        return count;
    }
}
