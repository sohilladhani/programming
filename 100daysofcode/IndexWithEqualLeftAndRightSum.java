/* https://binarysearch.com/problems/Index-with-Equal-Left-and-Right-Sums */

class Solution {
    public int solve(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        for (int i = 0; i < n; i++) leftSum[i] = nums[i];
        int[] rightSum = new int[n];
        for (int i = 0; i < n; i++) rightSum[i] = nums[i];
        for (int i = 1; i < n; i++) {
            leftSum[i] += leftSum[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] += rightSum[i + 1];
        }
        for (int i = 0; i < n; i++) {
            if (leftSum[i] == rightSum[i])
                return i;
        }
        return -1;
    }
}
