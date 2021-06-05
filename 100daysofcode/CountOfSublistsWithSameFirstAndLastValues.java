/* https://binarysearch.com/problems/Count-of-Sublists-with-Same-First-and-Last-Values */

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], new Integer(map.getOrDefault(nums[i], 0) + 1));
            ans += map.get(nums[i]);
        }
        return ans;
    }
}
