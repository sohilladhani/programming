/* https://binarysearch.com/problems/Equal-Partitions */

class Solution {
    public boolean solve(int[] nums) {
        /* If the sum is odd, it can't be paritioned into 2 subsets*/
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum % 2 == 1) return false;
        else {
            //check if subset sum could equate to sum/2
            return subsetSum(nums, sum/2, nums.length);
        }
    }

    private boolean subsetSum(int[] nums, int sum, int n) {
        boolean[][] cache = new boolean[n+1][sum+1];
        for(int j = 0; j < sum + 1; j++) {
            cache[0][j] = false;
        }
        for(int i = 0; i < n + 1; i++) {
            cache[i][0] = true;
        }
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < sum + 1; j++) {
                if(nums[i - 1] <= j) {
                    cache[i][j] = cache[i-1][j - nums[i-1]] || cache[i-1][j];
                } else {
                    cache[i][j] = cache[i-1][j];
                }
            }
        }
        return cache[n][sum];
    }
}
