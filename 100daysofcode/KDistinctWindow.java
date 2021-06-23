/* https://binarysearch.com/problems/K-Distinct-Window */

import java.util.*;

class Solution {
    public int[] solve(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= nums.length - k; i++) {
            list.add(countDistinctNumber(nums, i, i + k - 1));
        }
        int[] ans = new int[list.size()];
        int index = 0;
        for (int ele : list) {
            ans[index++] = ele;
        }
        return ans;
    }

    private int countDistinctNumber(int[] nums, int start, int end) {
        Set<Integer> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            set.add(nums[i]);
        }
        return set.size();
    }
}
