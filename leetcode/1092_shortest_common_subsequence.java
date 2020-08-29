/* 1092. Shortest Common Supersequence 
 * https://leetcode.com/problems/shortest-common-supersequence/
 * Given two strings str1 and str2, return the shortest string that has both 
 * str1 and str2 as subsequences.  If multiple answers exist, you may return any 
 * of them.

(A string S is a subsequence of string T if deleting some number of characters 
from T (possibly 0, and the characters are chosen anywhere from T) results in 
the string S.)

Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
Note:

    1 <= str1.length, str2.length <= 1000
    str1 and str2 consist of lowercase English letters.
Explanation: https://youtu.be/823Grn4_dCQ?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
*/

class ShortestCommonSubsequence {
    int[][] cache;
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(); int m = str2.length();
        int [][] cache = new int[n+1][m+1];
        int i = 0; int j = 0;
        for(i = 0; i < n+1; i++) {
            cache[i][0] = i;
        }
        for(j = 0; j < m+1; j++) {
            cache[0][j] = j;
        }
        for(i = 1; i < n+1; i++) {
            for(j = 1; j < m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    cache[i][j] = 1 + cache[i-1][j-1];
                } else {
                    cache[i][j] = 1 + Math.min(cache[i-1][j], cache[i][j-1]);
                }
            }
        }
        
        // Method 1: Top down method of going backwards in the cache array.
        i = n; j = m;
        StringBuilder sb = new StringBuilder("");
        while(i > 0 && j > 0) {
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                sb.insert(0, str1.charAt(i-1));
                i--; j--;
            } else {
                if(cache[i][j-1] == cache[i][j] - 1) {
                    sb.insert(0, str2.charAt(j-1));
                    j--;
                } else {
                    sb.insert(0, str1.charAt(i-1));
                    i--;
                }
            }
        }
        while(i > 0) {
            sb.insert(0, str1.charAt(--i));
        }
        while(j > 0) {
            sb.insert(0, str2.charAt(--j));
        }
        return sb.toString();
    }

    public int shortestCommonSupersequenceLength(String str1, String str2) {
        int n = str1.length(); int m = str2.length();
        //cache = new int[n+1][m+1];
        //int ans = scsl(str1, str2, n, m); 
        //printCache(cache);
        //return ans;
        return scsl_tabular(str1,str2);
    }

    private int scsl(String X, String Y, int n, int m) {
        if(n == 0) return m;
        if(m == 0) return n;
        if(cache[n][m] != 0) return cache[n][m];

        if(X.charAt(n-1) == Y.charAt(m-1)) {
            return cache[n][m] = 1 + scsl(X, Y, n-1, m-1);
        } else {
            return cache[n][m] = 1 + Math.min(scsl(X,Y,n-1,m), scsl(X,Y,n,m-1));
        }
    }

    private int scsl_tabular(String X, String Y) {
        int n = X.length(); int m = Y.length();
        cache = new int[n+1][m+1];
        for(int i = 0; i < n+1; i++) {
            cache[i][0] = i;
        }
        for(int j = 0; j < m+1; j++) {
            cache[0][j] = j;
        }
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m+1; j++) {
                if(X.charAt(i-1) == Y.charAt(j-1)) {
                    cache[i][j] = 1 + cache[i-1][j-1];
                } else {
                    cache[i][j] = 1 + Math.min(cache[i-1][j], cache[i][j-1]);
                }
            }
        }
        printCache(cache);
        return cache[n][m];
    }

    private void printCache(int[][] cache) {
        for(int i = 0; i < cache.length; i++) {
            for(int j = 0; j < cache[i].length; j++) {
                System.out.print(cache[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printStringWithTimeInMs(String s) {
        long startTime = System.nanoTime();
        System.out.println(s);
        long endTime = System.nanoTime();
        System.out.println("Time: " + ((endTime - startTime)/1000_000) + " ms");
    }

    public static void main(String[] args) {
        ShortestCommonSubsequence scs = new ShortestCommonSubsequence();
        String X = "";
        String Y = "";
        X = "abac";
        Y = "cab";
        printStringWithTimeInMs(scs.shortestCommonSupersequence(X, Y));
        System.out.println(scs.shortestCommonSupersequenceLength(X,Y));
        X = "geek";
        Y = "eke";
        printStringWithTimeInMs(scs.shortestCommonSupersequence(X, Y));
        System.out.println(scs.shortestCommonSupersequenceLength(X,Y));
    }
}
