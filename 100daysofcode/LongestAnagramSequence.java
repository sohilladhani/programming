/* https://binarysearch.com/problems/Longest-Anagram-Subsequence */

import java.util.*;

class Solution {
    public int solve(String a, String b) {
        int ans = 0;
        int[] ascii = new int[26];
        for(char A: a.toCharArray()) {
            ascii[A - 'a']++;
        }
        for(char B: b.toCharArray()) {
            if(ascii[B - 'a'] != 0) {
                ans++;
                ascii[B - 'a']--;
            }
        }
        return ans;
    }
}
