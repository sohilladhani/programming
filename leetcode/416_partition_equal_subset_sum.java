/* 416. Partition Equal Subset Sum
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:

    Each of the array element will not exceed 100.
    The array size will not exceed 200.

Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].

 
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.

*/

class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        /* If the sum is odd, it can't be paritioned into 2 subsets*/
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum % 2 == 1) {
            return false;
        }
        else {
            /* Now we just need to find if the there is a subset that could sum up to
            sum/2 ==> the problem is now reduced to subset sum problem with sum = sum/2*/
            return subsetSum(nums, sum/2, nums.length);
        }
    }
    
    private boolean subsetSum(int[] arr, int sum, int n) {
        boolean[][] cache = new boolean[n + 1][sum + 1];
        for(int j = 0; j < sum + 1; j++) {
            cache[0][j] = false;
        }
        for(int i = 0; i < n + 1; i++) {
            cache[i][0] = true;
        }
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < sum + 1; j++) {
                if(arr[i - 1] <= j) {
                    cache[i][j] = cache[i-1][j - arr[i-1]] || cache[i-1][j];
                } else {
                    cache[i][j] = cache[i-1][j];
                }
            }
        }
        return cache[n][sum];
    }
}
