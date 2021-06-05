/* https://binarysearch.com/problems/Sum-Pairs-to-Target */

import java.util.*;

class Solution {
    public int solve(int[] nums, int target) {
        int ans = 0;
        int i = 0;
        int j = nums.length - 1;
        Arrays.sort(nums);
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                ans++;
                i++;
                j--;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return ans;
    }
}
