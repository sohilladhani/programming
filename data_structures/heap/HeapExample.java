/* Program to use Java's implementation of Min Heap and Max Heap
 *
 * */

import java.util.PriorityQueue;
import java.util.Comparator;

class HeapExample {

    PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;

    public HeapExample() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public static void main(String[] args) {
        HeapExample heapEx = new HeapExample();
        int[] arr = {59, 1, 4, 66, 0, 12};
        for(int i = 0; i < arr.length; i++) {
            heapEx.minHeap.add(arr[i]);
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println("removing: " + heapEx.minHeap.poll());
        }
        System.out.println();
        for(int i = 0; i < arr.length; i++) {
            heapEx.maxHeap.add(arr[i]);
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println("removing: " + heapEx.maxHeap.poll());
        }
    }
}
