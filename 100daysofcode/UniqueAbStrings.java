/* https://binarysearch.com/problems/Unique-Ab-Strings */

class Solution {
    public int solve(String s) {
        int aCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                aCount++;
            }
        }
        return (int) Math.pow(2, aCount);
    }
}
