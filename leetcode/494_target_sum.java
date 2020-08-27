/*  494. Target Sum
 *  https://leetcode.com/problems/target-sum/
 *  You are given a list of non-negative integers, a1, a2, ..., an, and a target,
 *  S. Now you have 2 symbols + and -. For each integer, you should choose one 
 *  from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.

Constraints:

    The length of the given array is positive and will not exceed 20.
    The sum of elements in the given array will not exceed 1000.
    Your output answer is guaranteed to be fitted in a 32-bit integer.
 *
 * Watch https://youtu.be/Hw6Ygp3JBYw?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
 * for explanation
 */
class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        /* Considering nums[i] = 0 separately. In considering 0 value, 
        we keep a count, and when finding the subsets, we ignore zero. When final
        answer is to be returned, we calculate the power set of zero elements and
        multiply with answer for non-zero elements. */
        int zeroCount = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(nums[i] == 0) {
                zeroCount++;
            }
        }
        if((sum + S) % 2 != 0) return 0;
        if(S > sum) return 0;
        sum = (sum + S)/2;
        return (int) Math.pow(2, zeroCount) * countSubsets(nums, sum, nums.length);
    }
    
    private int countSubsets(int[] nums, int sum, int n) {
        int[][] cache = new int[n + 1][sum + 1];
        for(int i = 0; i < n + 1; i++) {
            cache[i][0] = 1;
        }
        for(int j = 1; j < sum + 1; j++) {
            cache[0][j] = 0;
        }
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < sum + 1; j++) {
                if(nums[i - 1] == 0) {
                    /* ignoring zero value*/
                    cache[i][j] = cache[i-1][j];
                }else if(nums[i - 1] <= j) {
                    cache[i][j] = cache[i - 1][j - nums[i-1]] + cache[i-1][j];
                } else {
                    cache[i][j] = cache[i-1][j];
                }
            }
        }
        return cache[n][sum];
    }
}
