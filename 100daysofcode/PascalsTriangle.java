/* https://binarysearch.com/problems/Pascal's-Triangle */

import java.util.*;

class Solution {
    public int[] solve(int n) {
        List<Integer> ans = new ArrayList<>();
        int elem = 1;
        int denominator = 1;
        int numerator = n;

        for (int i = 0; i <= n; i++) {
            ans.add(elem);
            elem = (elem * numerator) / denominator;
            numerator--;
            denominator++;
        }
        int[] res = new int[ans.size()];
        int idx = 0;
        for (int ele : ans) {
            res[idx++] = ele;
        }
        return res;
    }
}
