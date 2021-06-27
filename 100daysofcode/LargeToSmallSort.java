/* https://binarysearch.com/problems/Large-to-Small-Sort */

import java.util.*;

class Solution {
    public int[] solve(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[nums.length];
        int i = 0;
        int j = ans.length - 1;
        int index = 0;
        while (i <= j) {
            ans[index++] = nums[j];
            if (index < nums.length)
                ans[index] = nums[i];
            i++;
            j--;
            index++;
        }
        return ans;
    }
}
