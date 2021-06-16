/* https://binarysearch.com/problems/Longest-Sign-Alternating-Subsequence */

class Solution {
    public int solve(int[] nums) {
        int longest = 1;
        boolean positive = false;
        if (nums[0] > 0)
            positive = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0 && positive == false) {
                longest++;
                positive = true;
            } else if (nums[i] < 0 && positive == true) {
                longest++;
                positive = false;
            }
        }
        return longest;
    }
}
