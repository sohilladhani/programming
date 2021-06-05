/* https://binarysearch.com/problems/Lexicographically-Bigger-String */

import java.util.*;

class Solution {
    public boolean solve(String s, String t) {
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        Arrays.sort(S);
        Arrays.sort(T);
        boolean ans1 = true;
        boolean ans2 = true;
        for (int i = 0; i < S.length; i++) {
            if (S[i] - 'a' <= T[i] - 'a')
                ans1 = ans1 && true;
            else {
                ans1 = false;
                break;
            }
        }

        for (int i = 0; i < S.length; i++) {
            if (T[i] - 'a' <= S[i] - 'a')
                ans2 = ans2 && true;
            else {
                ans2 = ans2 && false;
                break;
            }
        }
        return ans1 || ans2;
    }
}
