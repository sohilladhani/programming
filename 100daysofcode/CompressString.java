/* https://binarysearch.com/problems/Compress-String */

class Solution {
    public String solve(String s) {
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder("");
        while (i < s.length()) {
            sb.append(s.charAt(i));
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            i = j;
        }
        return sb.toString();
    }
}
