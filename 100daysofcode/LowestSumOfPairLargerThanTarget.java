/* https://binarysearch.com/problems/Lowest-Sum-of-Pair-Larger-than-Target */

class Solution {
    public int solve(int[] nums, int target) {
        Arrays.sort(nums);
        int n1 = 0;
        int n2 = 0;
        int lowest = Integer.MAX_VALUE;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                if (lowest > nums[i] + nums[j]) {
                    lowest = nums[i] + nums[j];
                    n1 = nums[i];
                    n2 = nums[j];
                }
                j--;
            } else {
                i++;
            }
        }
        return n1 + n2;
    }
}
