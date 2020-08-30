/* 132. Palindrome Partitioning II
 * Given a string s, partition s such that every substring of the partition is 
 * a palindrome

Return the minimum cuts needed for a palindrome partitioning of s.

Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

Example 2:

Input: s = "a"
Output: 0

Example 3:

Input: s = "ab"
Output: 1

Constraints:

    1 <= s.length <= 2000
    s consists of lower-case English letters only.
*/

class PalindromePartioning2 {
    int[][] cache;
    public int minCut(String s) {
        int length = s.length();
        if(isPalindrome(s, 0, length-1)) return 0;
        cache = new int[length+1][length+1];
        return palindromePartitioning(s, 0, length-1);
    }
    
    private int palindromePartitioning(String s, int i, int j) {
        if(i == j) return 0;
        if(cache[i][j] != 0) return cache[i][j];
        if(isPalindrome(s, i, j)) {
            return cache[i][j] = 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++) {
            int temp = palindromePartitioning(s, i, k) +
                       palindromePartitioning(s, k+1, j) +
                       1;
            min = Math.min(min, temp);
        }
        return cache[i][j] = min;
    }
    
    private boolean isPalindrome(String s, int i, int j) {
        if(i == j) return true;
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
