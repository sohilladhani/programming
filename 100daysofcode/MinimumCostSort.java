import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int[] newNums = new int[nums.length];
        int ascendingSum = 0;
        int descendingSum = 0;
        int idx = 0;
        for (int ele : nums) {
            newNums[idx++] = ele;
        }
        Arrays.sort(newNums);
        for (int i = 0; i < nums.length; i++) {
            ascendingSum += Math.abs(nums[i] - newNums[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            descendingSum += Math.abs(nums[nums.length - 1 - i] - newNums[i]);
        }

        return Math.min(descendingSum, ascendingSum);
    }
}
