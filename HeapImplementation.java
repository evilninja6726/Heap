package heapDs;

public class HeapImplementation {
    public static void main(String[] args) {
        MinHeap h = new MinHeap(11);
        h.insert(3);
        h.insert(2);
        h.insert(15);
        h.insert(20);
        h.insert(12);
        h.insert(54);
        h.insert(21);
        h.insert(27);
        System.out.println(h.extractMin());
        h.decreaseKey(6, 1);
        System.out.println(h.extractMin());
        h.delete(0);
        System.out.println(h.extractMin());
    }
}

class MinHeap {
    int[] arr;
    int size;
    int capacity;

    MinHeap(int capacity) {
        this.capacity = capacity;
        size = 0;
        arr = new int[capacity];
    }

    int left(int i) {
        return ((2 * i) + 1);
    }

    int right(int i) {
        return ((2 * i) + 2);
    }

    int parent(int i) {
        return ((i - 1) / 2);
    }

    void insert(int data) {
        if (size == capacity)
            return;
        size++;
        arr[size - 1] = data;
        for (int i = size - 1; i >= 0 && arr[parent(i)] > arr[i]; ) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    void heapify(int index) {
        int left = left(index);
        int right = right(index);
        int min = index;
        if (left < size && arr[left] < arr[min])
            min = left;
        if (right < size && arr[right] < arr[min])
            min = right;
        if (min != index) {
            int temp = arr[min];
            arr[min] = arr[index];
            arr[index] = temp;
            heapify(min);
        }
    }

    int extractMin() {
        if (size == 0)
            return Integer.MIN_VALUE;
        if (size == 1) {
            size--;
            return arr[0];
        }
        int temp = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = temp;
        size--;
        heapify(0);
        return arr[size];
    }

    void decreaseKey(int index, int x) {
        if (index >= size)
            return;
        arr[index] = x;
        for (int i = index; i >= 0 && arr[i] < arr[parent(i)]; ) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    void delete(int index) {
        if (index >= size)
            return;
        size--;
        decreaseKey(index, Integer.MIN_VALUE);
        extractMin();
    }

    void buildHeap() {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            heapify(i);
        }
    }
}