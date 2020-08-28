/* 1143. Longest Common Subsequence
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string 
with some characters(can be none) deleted without changing the relative order 
of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" 
is not). A common subsequence of two strings is a subsequence that is common to 
both strings.

If there is no common subsequence, return 0.

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

Constraints:

    1 <= text1.length <= 1000
    1 <= text2.length <= 1000
    The input strings consist of lowercase English characters only.

*/

class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, text1.length(), text2.length()); 
    }
    
    private int lcs(String X, String Y, int n, int m) {
        if(n == 0 || m == 0) return 0;
        
        if(X.charAt(n - 1) == Y.charAt(m - 1)) {
            return (1 + lcs(X, Y, n-1, m-1));
        } else {
            return Math.max(lcs(X, Y, n, m-1), lcs(X, Y, n-1, m));
        }
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String X = "abcde";
        String Y = "ace";
        System.out.println(lcs.longestCommonSubsequence(X, Y));
    }
}
