/* https://binarysearch.com/problems/Cell-Fusion */

import java.util.*;

class Solution {
    public int solve(int[] cells) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < cells.length; i++) {
            maxHeap.offer(cells[i]);
        }
        int ele = -1;
        while (!maxHeap.isEmpty()) {
            ele = maxHeap.poll();
            if (!maxHeap.isEmpty()) {
                if (ele == maxHeap.peek()) {
                    maxHeap.poll();
                    ele = -1;
                } else {
                    maxHeap.offer((ele + maxHeap.poll()) / 3);
                }
            }
        }
        return ele;
    }
}
