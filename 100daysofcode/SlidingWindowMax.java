/* https://binarysearch.com/problems/Sliding-Window-Max */

import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int num;
        int index;
        Pair(int num, int index) {
            this.num = num;
            this.index = index;
        }
        @Override
        public int compareTo(Pair other) {
            return this.num - other.num;
        }
    }

    public int[] solve(int[] nums, int k) {
        if (k == 1)
            return nums;
        int[] ans = new int[nums.length - k + 1];
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int idx = 0;
        for (int i = 0; i < k; i++) {
            maxHeap.offer(new Pair(nums[i], i));
        }
        ans[idx++] = maxHeap.peek().num;

        for (int i = k; i < nums.length; i++) {
            while (maxHeap.peek().index < i - k + 1) {
                maxHeap.poll();
            }
            maxHeap.add(new Pair(nums[i], i));
            ans[idx++] = maxHeap.peek().num;
        }
        return ans;
    }
}
