/* https://binarysearch.com/problems/Happy-Numbers */

import java.util.*;

class Solution {
    public boolean solve(int n) {
        boolean ans = false;
        HashSet<Integer> set = new HashSet<>();
        while(n != 1) {
            set.add(n);
            int r = 0;
            while(n > 0) {
                r += Math.pow((n%10), 2);
                n = n/10;
            }
            n = r;
            if(set.contains(n)) return false;
        }
        if(n == 1) return true;
        return false;
    }
}
