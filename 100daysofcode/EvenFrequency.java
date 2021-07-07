/* https://binarysearch.com/problems/Even-Frequency */

import java.util.*;

class Solution {
    public boolean solve(int[] nums) {
        if (nums.length % 2 == 1)
            return false;
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i])
                count++;
            else {
                if (count % 2 == 1)
                    return false;
                count = 1;
            }
        }
        return true;
    }
}
