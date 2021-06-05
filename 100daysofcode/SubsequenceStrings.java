/* https://binarysearch.com/problems/Subsequence-Strings */

class Solution {
    public boolean solve(String s1, String s2) {
        int i = 0;
        for(int j = 0; j < s2.length(); j++) {
            if(i < s1.length() && s2.charAt(j) == s1.charAt(i)) {
                i++;
            }
            if(i == s1.length()) return true;
        }

        return i == s1.length();
    }
}
