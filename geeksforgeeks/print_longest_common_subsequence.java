/* Given two sequences, print the longest subsequence present in both of them.
Example:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3. 
*/

class PrintLongestCommonSubsequence {
    public String plcsMethod2(String X, String Y) {
        /* Explanation: 
         * https://youtu.be/x5hQvnUcjiM?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
         */
        int n = X.length(); int m = Y.length();
        int[][] cache = new int[n+1][m+1];
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < n+1; i++) cache[i][0] = 0;
        for(int j = 0; j < m+1; j++) cache[0][j] = 0;

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m+1; j++) {
                if(X.charAt(i-1) == Y.charAt(j-1)) {
                    cache[i][j] = 1 + cache[i-1][j-1];
                } else {
                    cache[i][j] = Math.max(cache[i-1][j], cache[i][j-1]);
                }
            }
        }
        int i = n; int j = m; 
        while(i>0 && j>0) {
            if(X.charAt(i-1) == Y.charAt(j-1)) {
                sb.insert(0, X.charAt(i-1));
                i--; j--;
            } else {
                if(cache[i-1][j] > cache[i][j-1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return sb.toString();
    }

    public String printLongestCommonSubsequence(String X, String Y) {
        int n = X.length(); int m = Y.length();
        StringBuilder[][] cache = new StringBuilder[n+1][m+1];
        for(int i = 0; i < n+1; i++) cache[i][0] = new StringBuilder("");
        for(int j = 0; j < m+1; j++) cache[0][j] = new StringBuilder("");
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m+1; j++) {
                if(X.charAt(i-1) == Y.charAt(j-1)) {
                    cache[i][j] = new StringBuilder(cache[i-1][j-1].append(X.charAt(i-1)));
                } else {
                    if(cache[i-1][j].length() > cache[i][j-1].length()) {
                        cache[i][j] = new StringBuilder(cache[i-1][j]);
                    } else {
                        cache[i][j] = new StringBuilder(cache[i][j-1]);
                    }
                }
            }
        }
        return cache[n][m].toString();
    }
    
    private void printCache(StringBuilder[][] cache) {
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
        PrintLongestCommonSubsequence lcs = new PrintLongestCommonSubsequence();
        String X = ""; String Y = "";
        X = "mhunuzqrkzsnidwbun";
        Y = "szulspmhwpazoxijwbq";
        printStringWithTimeInMs(lcs.printLongestCommonSubsequence(X, Y));
        printStringWithTimeInMs(lcs.plcsMethod2(X, Y));

        X = "abcdgh";
        Y = "aedfhr";
        printStringWithTimeInMs(lcs.printLongestCommonSubsequence(X, Y));
        printStringWithTimeInMs(lcs.plcsMethod2(X, Y));

        X = "acbcf";
        Y = "abcdaf";
        printStringWithTimeInMs(lcs.printLongestCommonSubsequence(X, Y));
        printStringWithTimeInMs(lcs.plcsMethod2(X, Y));
    }
}
