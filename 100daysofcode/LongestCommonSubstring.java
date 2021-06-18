/* https://binarysearch.com/problems/Longest-Common-Substring */

class Solution {
    public int solve(String s0, String s1) {
        int m = s0.length();
        int n = s1.length();
        int ans = 0;
        int[][] cache = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0;
                } else if (s0.charAt(i - 1) == s1.charAt(j - 1)) {
                    cache[i][j] = 1 + cache[i - 1][j - 1];
                    ans = Math.max(ans, cache[i][j]);
                } else {
                    cache[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
