/* https://binarysearch.com/problems/Range-Update */

class Solution {
    public int[] solve(int[] nums, int[][] operations) {
        for (int i = 0; i < operations.length; i++) {
            for (int j = operations[i][0]; j <= operations[i][1]; j++) {
                nums[j] += operations[i][2];
            }
        }
        return nums;
    }
}
