/* https://binarysearch.com/problems/Multiset-Sum */

class Solution {
    public int solve(int[] nums, int k) {
        int[][] cache = new int[nums.length + 1][k + 1];

        for (int i = 0; i < cache.length; i++) {
            cache[i][0] = 1;
        }
        for (int j = 0; j < cache[0].length; j++) {
            cache[0][j] = 0;
        }

        for (int i = 1; i < cache.length; i++) {
            for (int j = 1; j < cache[i].length; j++) {
                if (nums[i - 1] <= j) {
                    cache[i][j] = cache[i][j - nums[i - 1]] + cache[i - 1][j];
                } else {
                    cache[i][j] = cache[i - 1][j];
                }
            }
        }
        return cache[nums.length][k];
    }
}
