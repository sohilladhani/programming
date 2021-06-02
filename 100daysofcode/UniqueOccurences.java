/* https://binarysearch.com/problems/Unique-Occurrences */

import java.util.*;

class Solution {
    public boolean solve(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], new Integer(map.getOrDefault(nums[i], 0) + 1));
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            freq.put(entry.getValue(), 
                    new Integer(freq.getOrDefault(entry.getValue(), 0) + 1));
            if(freq.get(entry.getValue()) > 1) return false;
        }
        return true;
    }
}
