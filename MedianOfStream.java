package heapDs;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {
    public static void main(String[] args) {
        medianOfStream(new double[]{25, 7, 10, 15, 20});
        System.out.println();
        medianOfStream(new double[]{5, 12, 17, 18, 2, 20, 10, 1, 13, 15, 7, 6, 5, 4, 3});
        System.out.println();
        medianOfStreamMoreEff(new double[]{25, 7, 10, 15, 20});
        System.out.println();
        medianOfStreamMoreEff(new double[]{5, 12, 17, 18, 2, 20, 10, 1, 13, 15, 7, 6, 5, 4, 3});
        System.out.println();
        medianOfStreamMostEff(new double[]{25, 7, 10, 15, 20});
        System.out.println();
        medianOfStreamMostEff(new double[]{5, 12, 17, 18, 2, 20, 10, 1, 13, 15, 7, 6, 5, 4, 3});
    }

    public static void medianOfStream(double[] arr) {
        double[] sorted = new double[arr.length];
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            sorted[i] = arr[i];/**/
            size++;
            int j = i;
            while (j > 0 && sorted[j] < sorted[j - 1]) {
                double temp = sorted[j];
                sorted[j] = sorted[j - 1];
                sorted[j - 1] = temp;
                j--;
            }
            if (size % 2 == 0)
                System.out.print(((sorted[size / 2] + sorted[(size - 1) / 2]) / 2) + " ");
            else
                System.out.print(sorted[size / 2] + " ");
        }
    }

    public static void medianOfStreamMoreEff(double[] arr) {
        NodeWithLCount root = null;
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
            size++;
            if (size % 2 == 0)
                System.out.print(((kthSmallest(root, size / 2).data) + (kthSmallest(root, (size / 2) + 1).data)) / 2 + " ");
            else
                System.out.print(kthSmallest(root, (size / 2) + 1).data + " ");
        }
    }

    public static NodeWithLCount insert(NodeWithLCount root, double x) {
        if (root == null)
            return new NodeWithLCount(x);
        if (root.data > x) {
            root.left = insert(root.left, x);
            root.lCount++;
        } else if (root.data < x)
            root.right = insert(root.right, x);
        return root;
    }

    public static NodeWithLCount kthSmallest(NodeWithLCount root, int k) {
        if (root == null)
            return null;
        int count = root.lCount + 1;
        if (count == k)
            return root;
        else if (count > k)
            return kthSmallest(root.left, k);
        else
            return kthSmallest(root.right, k - count);
    }

    public static void medianOfStreamMostEff(double[] arr) {
        PriorityQueue<Double> p1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Double> p2 = new PriorityQueue<>();
        p1.add(arr[0]);
        System.out.print(p1.peek() + " ");
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > p1.peek()) {
                p2.add(arr[i]);
                if (p2.size() > p1.size())
                    p1.add(p2.poll());
            } else if (arr[i] < p1.peek()) {
                p1.add(arr[i]);
                if (p1.size() > p2.size() + 1)
                    p2.add(p1.poll());
            }
            if (i % 2 == 0)
                System.out.print(p1.peek() + " ");
            else
                System.out.print((p1.peek() + p2.peek()) / 2 + " ");
        }
    }
}

class NodeWithLCount {
    double data;
    NodeWithLCount left;
    NodeWithLCount right;
    int lCount;

    NodeWithLCount(double data) {
        this.data = data;
    }
}