/* https://binarysearch.com/problems/Rolling-Median */

import java.util.*;

class RollingMedian {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    boolean even = true;
    public RollingMedian() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void add(int val) {
        even = !even;
        if (minHeap.size() == 0 && maxHeap.size() == 0) {
            maxHeap.add(val);
            return;
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(val);
        } else if (maxHeap.size() == minHeap.size()) {
            maxHeap.add(val);
        }
        if (maxHeap.peek() > minHeap.peek()) {
            maxHeap.add(minHeap.poll());
            minHeap.add(maxHeap.poll());
        }
    }

    public double median() {
        if (even == true) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }
}
