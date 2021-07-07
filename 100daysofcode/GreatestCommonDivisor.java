/* https://binarysearch.com/problems/Greatest-Common-Divisor */

class Solution {
    public int solve(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int a = nums[0];
        int b = nums[1];
        int gcdValue = gcd(a, b);
        for (int i = 2; i < nums.length; i++) {
            gcdValue = gcd(gcdValue, nums[i]);
        }
        return gcdValue;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
