/* https://binarysearch.com/problems/Add-One-to-List */

class Solution {
    public int[] solve(int[] nums) {
        int sum = nums[nums.length - 1] + 1;
        nums[nums.length - 1] = sum % 10;
        int carry = sum / 10;
        for(int i = nums.length - 2; i >= 0; i--) {
            sum = carry + nums[i];
            nums[i] = sum % 10;
            carry = sum / 10;
        }
        if(carry >= 1) {
            int[] ans = new int[nums.length + 1];
            ans[0] = carry;
            for(int i = 0; i < nums.length; i++) {
                ans [i+1] = nums[i];
            }
            return ans;
        }
        return nums;
    }
}
