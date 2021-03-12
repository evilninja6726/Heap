package heapDs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(10);
        a1.add(20);
        a1.add(30);
        arr.add(a1);
        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(5);
        a2.add(15);
        arr.add(a2);
        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(1);
        a3.add(9);
        a3.add(11);
        a3.add(18);
        arr.add(a3);
        System.out.println(mergeKSortedArrays(arr));
        System.out.println(mergeKSortedArraysMoreEff(arr));
        System.out.println(mergeKSortedArraysMostEff(arr));
    }

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> arrayLists) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (ArrayList<Integer> a : arrayLists)
            for (int x : a)
                arrayList.add(x);
        Collections.sort(arrayList);
        return arrayList;

    }

    public static ArrayList<Integer> mergeKSortedArraysMoreEff(ArrayList<ArrayList<Integer>> arrayLists) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList = arrayLists.get(0);
        for (int i = 1; i < arrayLists.size(); i++)
            arrayList = mergeSort(arrayList, arrayLists.get(i));
        return arrayList;
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a1.size() && j < a2.size()) {
            if (a1.get(i) > a2.get(j))
                arrayList.add(a2.get(j++));
            else
                arrayList.add(a1.get(i++));
        }
        while (i < a1.size())
            arrayList.add(a1.get(i++));
        while (j < a2.size())
            arrayList.add(a2.get(j++));
        return arrayList;
    }

    public static ArrayList<Integer> mergeKSortedArraysMostEff(ArrayList<ArrayList<Integer>> arrayLists) {
        PriorityQueue<Triplets> priorityQueue = new PriorityQueue<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arrayLists.size(); i++)
            priorityQueue.add(new Triplets(arrayLists.get(i).get(0), i, 0));
        while (!priorityQueue.isEmpty()) {
            Triplets t = priorityQueue.poll();
            arrayList.add(t.getElement());
            if (t.getDeepIndex() + 1 < arrayLists.get(t.getMainIndex()).size())
                priorityQueue.add(new Triplets(arrayLists.get(t.getMainIndex()).get(t.getDeepIndex() + 1),
                        t.getMainIndex(),
                        t.getDeepIndex() + 1));
        }
        return arrayList;
    }
}

class Triplets implements Comparable<Triplets> {
    private int element;
    private int mainIndex;
    private int deepIndex;

    Triplets(int element, int mainIndex, int deepIndex) {
        this.element = element;
        this.mainIndex = mainIndex;
        this.deepIndex = deepIndex;
    }

    @Override
    public int compareTo(Triplets o) {
        if (this.getElement() < o.getElement())
            return -1;
        return 1;
    }

    int getElement() {
        return element;
    }

    int getMainIndex() {
        return mainIndex;
    }

    int getDeepIndex() {
        return deepIndex;
    }
}