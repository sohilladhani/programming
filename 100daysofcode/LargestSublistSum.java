/* https://binarysearch.com/problems/Largest-Sublist-Sum */

class Solution {
    public int solve(int[] nums) {
        int maxTillNow = nums[0];
        int maxOverall = maxTillNow;
        for(int i = 1; i < nums.length; i++) {
            maxTillNow = Math.max(nums[i] + maxTillNow, nums[i]);
            maxOverall = Math.max(maxOverall, maxTillNow);
        }
        return maxOverall = Math.max(maxOverall, maxTillNow);
    }
}
