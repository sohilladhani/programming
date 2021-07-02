/* https://binarysearch.com/problems/Increasing-Digits */

class Solution {
    public int solve(int n) {
        int[] nums = new int[10];
        nums[1] = 9;
        nums[2] = 36;
        nums[3] = 84;
        nums[4] = 126;
        nums[5] = 126;
        nums[6] = 84;
        nums[7] = 36;
        nums[8] = 9;
        nums[9] = 1;

        if (n > 9)
            return 0;
        return nums[n];
    }
}
