package heapDs;

import java.util.PriorityQueue;

public class SortAKSortedArray {
    public static void main(String[] args) {
        sortAKSortedArray(new int[]{9, 8, 7, 18, 19, 17}, 2);
        System.out.println();
        sortAKSortedArray(new int[]{2, 6, 3, 12, 56, 8}, 3);
    }

    public static void sortAKSortedArray(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i <= k; i++)
            priorityQueue.add(arr[i]);
        int index = 0;
        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }
        while (!priorityQueue.isEmpty())
            arr[index++] = priorityQueue.poll();
        printSorted(arr);
    }

    static void printSorted(int[] arr) {
        for (int x : arr)
            System.out.print(x + " ");
    }
}
