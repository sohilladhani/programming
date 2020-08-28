/* Longest Common Substring 
 *

Given two strings X and Y. The task is to find the length of the longest common substring.

Input:
First line of the input contains number of test cases T. Each test case consist of three lines, first of which contains 2 space separated integers N and M denoting the size of string X and Y strings respectively. The next two lines contains the string X and Y.

Output:
For each test case print the length of longest  common substring of the two strings .

Constraints:
1 <= T <= 200
1 <= N, M <= 100

Example:
Input:
2
6 6
ABCDGH
ACDGHR
3 2
ABC
AC

Output:
4
1

Example:
Testcase 1: CDGH is the longest substring present in both of the strings.
 
*/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class LongestCommonSubstring {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
		  String sizes[] = br.readLine().split(" ");
		  int n = Integer.parseInt(sizes[0]);
	      int m = Integer.parseInt(sizes[1]);
	      
	      String X = br.readLine();
	      String Y = br.readLine();
		  System.out.println(lcsubstring(X,Y,n,m));
		}
	}
	
	private static int lcsubstring(String X, String Y, int n, int m) {
	    int[][] cache = new int[n+1][m+1];
	    int max = 0;
	    for(int i = 1; i < n+1; i++) {
	        for(int j = 1; j < m+1; j++) {
	            if(X.charAt(i-1) == Y.charAt(j-1)) {
	                cache[i][j] = 1 + cache[i-1][j-1];
	                max = Math.max(max, cache[i][j]);
	            } else {
	                cache[i][j] = 0;
	            }
	        }
	    }
	    return max;
	}
}
