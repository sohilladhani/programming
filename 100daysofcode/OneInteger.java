/* https://binarysearch.com/problems/One-Integer */

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int ans = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);
        }

        while(minHeap.size() != 1) {
            int sum = minHeap.poll() + minHeap.poll();
            ans += sum;
            minHeap.offer(sum);
        }
        return ans;
    }
}
