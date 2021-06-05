/* https://binarysearch.com/problems/N-Lexicographic-Integers */

import java.util.*;

class Solution {
    public int[] solve(int n) {
        String[] ans = new String[n];
        int[] sol = new int[n];
        for(int i = 1; i <= n; i++) {
            ans[i-1] = String.valueOf(i);
        }
        Arrays.sort(ans);
        for(int i = 0; i < ans.length; i++) {
            sol[i] = Integer.parseInt(ans[i]);
        }
        return sol;
    }
}
