/* https://binarysearch.com/problems/Skip-Tasks-to-Minimize-Work */

class Solution {
    int[][] cache;
    public int solve(int[] nums) {
        cache = new int[nums.length + 1][2];
        for (int i = 0; i < cache.length; i++) {
            cache[i][0] = -1;
            cache[i][1] = -1;
        }
        return skipTask(nums, nums.length, 0);
    }

    private int skipTask(int[] nums, int n, int skip) {
        if (n == 0)
            return 0;
        if (cache[n][skip] != -1)
            return cache[n][skip];
        if (skip == 1) {
            return cache[n][skip] = nums[n - 1] + skipTask(nums, n - 1, 0);
        } else {
            return cache[n][skip] =
                       Math.min(nums[n - 1] + skipTask(nums, n - 1, 0), skipTask(nums, n - 1, 1));
        }
    }
}
