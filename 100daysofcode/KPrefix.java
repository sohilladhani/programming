/* https://binarysearch.com/problems/K-Prefix */

class Solution {
    public int solve(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= k)
                return i;
        }
        return -1;
    }
}
