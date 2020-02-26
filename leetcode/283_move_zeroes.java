/* 283. Move Zeroes - https://leetcode.com/problems/move-zeroes */
/* Given an array nums, write a function to move all 0's to the end of it while 
 * maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
*/

class MoveZeroes {
    public void moveZeroes(int[] nums) {
/*        int numOfZeroes = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                numOfZeroes++;
            }
        }
*/
        int flag = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            flag = 0;            
            for(int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j] == 0 && nums[j+1] != 0) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = 1;
                }
            }
            if(flag == 0) break;
        }
    }

    public static void main (String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[] nums = {0, 15, 0, 3, 12, 0, 25};
        mz.moveZeroes(nums);
        System.out.println(Utils.integerArrayToString(nums, nums.length));
        int[] nums1 = {0};
        mz.moveZeroes(nums1);
        System.out.println(Utils.integerArrayToString(nums1, nums1.length));
        int[] nums2 = {1, 0, 0};
        mz.moveZeroes(nums2);
        System.out.println(Utils.integerArrayToString(nums2, nums2.length));
        int[] nums3 = {1};
        mz.moveZeroes(nums3);
        System.out.println(Utils.integerArrayToString(nums3, nums3.length));
        int[] nums4 = {};
        mz.moveZeroes(nums4);
        System.out.println(Utils.integerArrayToString(nums4, nums4.length));
    }
}
