package heapDs;

public class HeapSort {
    public static void main(String[] args) {
        heapSort(new int[]{2, 12, 17, 5, 4, 3, 1, 11}, 8);
    }

    public static void heapSort(int[] arr, int n) {
        buildMaxHeap(arr, n);
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            maxHeapify(0, arr, i);
        }
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int x : arr)
            System.out.print(x + " ");
    }

    public static void buildMaxHeap(int[] arr, int n) {
        for (int i = (n - 2) / 2; i >= 0; i--)
            maxHeapify(i, arr, n);
    }

    public static void maxHeapify(int index, int[] arr, int n) {
        int max = index;
        int left = ((2 * index) + 1);
        int right = ((2 * index) + 2);
        if (left < n && arr[left] > arr[max])
            max = left;
        if (right < n && arr[right] > arr[max])
            max = right;
        if (max != index) {
            int temp = arr[max];
            arr[max] = arr[index];
            arr[index] = temp;
            maxHeapify(max, arr, n);
        }
    }
}
