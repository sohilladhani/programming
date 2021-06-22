/* https://binarysearch.com/problems/Median-of-Two-Sorted-Lists */

class Solution {
    public int solve(int[] nums0, int[] nums1) {
        if (nums0.length > nums1.length)
            return solve(nums1, nums0);
        int n0 = nums0.length;
        int n1 = nums1.length;
        boolean isEven = (n0 + n1) % 2 == 0;

        int low = 0;
        int high = n0;
        while (low <= high) {
            int cut0 = (low + high) >> 1;
            int cut1 = (n0 + n1) / 2 - cut0;

            int left0 = cut0 == 0 ? Integer.MIN_VALUE : nums0[cut0 - 1];
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];

            int right0 = cut0 == n0 ? Integer.MAX_VALUE : nums0[cut0];
            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];

            if (left0 <= right1 && left1 <= right0) {
                return Math.min(right0, right1);
            } else if (left0 > right1) {
                high = cut0 - 1;
            } else {
                low = cut0 + 1;
            }
        }
        return 0;
    }
}
