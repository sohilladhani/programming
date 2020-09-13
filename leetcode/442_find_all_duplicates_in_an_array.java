/* 442. Find All Duplicates in an Array
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements 
 * appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

*
*/

class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> ansSet = new HashSet<>();
        int i = 0; int temp = 0;
        
        while(i < nums.length) {
            if(nums[i] != i+1) {
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                if(nums[i] == nums[nums[i] - 1]) {
                    i++;
                }
            } else {
                i++;
            }
        }
        
        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i+1) {
                ansSet.add(nums[i]);
            }
        }
        for(int element: ansSet) {
            ans.add(element);
        }
        return ans;
    }
}
