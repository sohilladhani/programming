/* https://binarysearch.com/problems/Remove-One-Letter */

class Solution {
    public boolean solve(String s0, String s1) {
        if(s0.length() != s1.length() + 1) return false;
        if(s1.length() == 0) return true;
        int i = 0; int j = 0;
        int length = 0;
        while(j < s0.length()) {
            if(s1.charAt(i) == s0.charAt(j)) {
                i++;
            }
            j++;
            if(i == s1.length()) return true;
        }
        return i == s1.length();
    }
}
