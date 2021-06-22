/* https://binarysearch.com/problems/Longest-Increasing-Subsequence */
import java.util.*;

class Solution {
    public int solve(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] cache = new int[nums.length];
        int max = 1;
        Arrays.fill(cache, 1);
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    cache[i] = Math.max(cache[i], cache[j] + 1);
                }
            }
            max = Math.max(max, cache[i]);
        }
        return max;
    }
}
