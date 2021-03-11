package heapDs;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class KLargestElement {
    public static void main(String[] args) {
        kLargestElement(new int[]{43, 65, 12, 33, 45, 63, 22, 17, 76}, 5);
        System.out.println();
        kLargestElementEff(new int[]{43, 65, 12, 33, 45, 63, 22, 17, 76}, 5);
    }

    public static void kLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : arr)
            priorityQueue.add(x);
        for (int i = 0; i < k; i++)
            System.out.print(priorityQueue.poll() + " ");
    }

    public static void kLargestElementEff(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            priorityQueue.add(arr[i]);
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }
        Iterator iterator = priorityQueue.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }
}
