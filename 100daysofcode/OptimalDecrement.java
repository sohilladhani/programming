/* https://binarysearch.com/problems/Optimal-Decrement */

import java.util.*;

class Solution {
    public int solve(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = 
          new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            maxHeap.offer(num);
        }
        while (k != 0) {
            maxHeap.offer(maxHeap.poll() - 1);
            k--;
        }
        return maxHeap.peek();
    }
}
