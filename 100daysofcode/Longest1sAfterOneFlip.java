/* https://binarysearch.com/problems/Longest-1s-After-One-Flip */

class Solution {
    public int solve(String s) {
        if (s.length() <= 1)
            return s.length();
        int longest = 0;
        int count = 0;
        int flipIndex = 0;
        int zeroCount = 0;
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (s.charAt(j) == '0') {
                zeroCount++;
                flipIndex = j;
                j++;
                while (j < s.length() && s.charAt(j) == '1') {
                    j++;
                }
                count = j - i;
                longest = Math.max(longest, count);
                count = 0;
                i = flipIndex + 1;
            } else {
                j++;
            }
        }
        return zeroCount == 0 ? s.length() : longest;
    }
}
