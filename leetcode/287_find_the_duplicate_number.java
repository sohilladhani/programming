/* 287. Find the Duplicate Number
 * https://leetcode.com/problems/find-the-duplicate-number/
 * Given an array of integers nums containing n + 1 integers where each integer 
 * is in the range [1, n] inclusive.

There is only one duplicate number in nums, return this duplicate number.

Follow-ups:

    How can we prove that at least one duplicate number must exist in nums? 
    Can you solve the problem without modifying the array nums?
    Can you solve the problem using only constant, O(1) extra space?
    Can you solve the problem with runtime complexity less than O(n2)?

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2

Example 2:

Input: nums = [3,1,3,4,2]
Output: 3

Example 3:

Input: nums = [1,1]
Output: 1

Example 4:

Input: nums = [1,1,2]
Output: 1

*/

class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        // swap sort
        int ans = 0;
        int i = 0;
        int temp = 0;
        while(i < nums.length) {
            if(nums[i] != i+1) {
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                if(nums[nums[i] - 1] == nums[i]) i++;
            } else {
                 i++;
            }
        }
        // then find duplicate
        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i+1) {
                ans = nums[i];
                break;
            } 
        }
        return ans;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber ftdn = new FindTheDuplicateNumber();
        int[] arr;
        arr = new int[] {1,3,4,2,2};
        System.out.println(ftdn.findDuplicate(arr));
        arr = new int[] {3,1,3,4,2};
        System.out.println(ftdn.findDuplicate(arr));
        arr = new int[] {1,1};
        System.out.println(ftdn.findDuplicate(arr));
        arr = new int[] {1,1,2};
        System.out.println(ftdn.findDuplicate(arr));
    }
}
