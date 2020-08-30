/* Minimum number of deletions and insertions to transform one string into another
 * https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/
 *
 * Given two strings ‘str1’ and ‘str2’ of size m and n respectively. The task is
 * to remove/delete and insert minimum number of characters from/in str1 so as 
 * to transform it into str2. It could be possible that the same character needs
 * to be removed/deleted from one point of str1 and inserted to some another
 * point.

Examples:

Input : str1 = "heap", str2 = "pea" 
Output : Minimum Deletion = 2 and
         Minimum Insertion = 1
p and h deleted from heap
Then, p is inserted at the beginning
One thing to note, though p was required yet
it was removed/deleted first from its position and
then it is inserted to some other position.
Thus, p contributes one to the deletion_count
and one to the insertion_count.

Input : str1 = "geeksforgeeks", str2 = "geeks"
Output : Minimum Deletion = 8
         Minimum Insertion = 0       

*/

class MinInsDelConvString {
    public int minInsDelConvString(String X, String Y) {
        /* Method:
         * Convert X to LCS and convert LCS to Y
         * X -> Y == X -> LCS -> Y
         * hence, operations = len(X) - len(LCS) + len (Y) - len(LCS)
         *                   = len(X) + len(Y) - 2*len(LCS)
         * */
        int n = X.length(); int m = Y.length();
        int[][] cache = new int[n+1][m+1];
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m+1; j++) {
                if(X.charAt(i-1) == Y.charAt(j-1)) {
                    cache[i][j] = 1 + cache[i-1][j-1];
                } else {
                    cache[i][j] = Math.max(cache[i-1][j], cache[i][j-1]);
                }
            }
        }
        return (m + n - 2*cache[n][m]);
    }    
    public static void main(String[] args) {
        MinInsDelConvString midcs = new MinInsDelConvString();
        String X = "";
        String Y = "";
        X = "heap";
        Y = "pea";
        System.out.println(midcs.minInsDelConvString(X,Y));
    }
}
