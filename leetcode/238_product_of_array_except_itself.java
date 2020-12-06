/* 238. Product of Array Except Self
 * 
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

*/

class ProductOfArray {
    public int[] productExceptSelfSpaceEfficient(int[] nums) {
        int length = nums.length;
        int res[] = new int[length];
        int product = 1;
        for(int i = 0; i < length; i++) {
            product = product * nums[i];
            res[i] = product;
        }
        product = 1;
        for(int i = length - 1; i >= 1; i--) {
            res[i] = product * res[i-1];
            product = product * nums[i];
        }
        res[0] = product;
        return res;
    }

    public int[] productExceptSelf(int[] nums) {
        //brute force
        //multiply other numbers except self - O(n^2)
        // [1,2,3,4]  
        //left = [1, 2, 6, 24] 
        //right = [24, 24, 12, 4] 
        //res = [24, 12, 8, 6]
        //
        //This is O(N) space and O(N) time solution
        
        int length = nums.length;
        int res[] = new int[length];
        int left[] = new int[length];
        int right[] = new int[length];
        int product = 1;
        for(int i = 0; i < length; i++) {
            product = product * nums[i];
            left[i] = product;
        }
        product = 1;
        for(int i = length-1; i >= 0; i--) {
            product = product * nums[i];
            right[i] = product;
        }
        res[0] = right[1];
        res[length - 1] = left[length-2];
        for(int i = 1; i < length - 1; i++) {
            res[i] = left[i-1] * right[i+1];
        }
        return res;
    }
}
