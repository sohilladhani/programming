/* https://binarysearch.com/problems/Verify-Max-Heap */

class Solution {
    public boolean solve(int[] nums) {
        boolean ans = true;
        for (int i = 0; i < nums.length; i++) {
            if (2 * i + 1 < nums.length) {
                ans = ans && (nums[i] >= nums[2 * i + 1]);
            }
            if (2 * i + 2 < nums.length) {
                ans = ans && (nums[i] >= nums[2 * i + 2]);
            }
        }
        return ans;
    }
}
