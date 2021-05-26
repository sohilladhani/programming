/* https://binarysearch.com/problems/Changing-Directions */

class Solution {
    enum Dir { STANDSTILL, POSITIVE, NEGATIVE };
    public int solve(int[] nums) {
        Dir dir = Dir.STANDSTILL;
        int ans = 0;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] > nums[i - 1]) {
                if (dir == Dir.NEGATIVE)
                    ans++;
                dir = Dir.POSITIVE;
            } else if (nums[i] < nums[i - 1]) {
                if (dir == Dir.POSITIVE)
                    ans++;
                dir = Dir.NEGATIVE;
            } else {
                dir = Dir.STANDSTILL;
            }
            i++;
        }
        return ans;
    }
}
