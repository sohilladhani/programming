/* https://binarysearch.com/problems/Robinhood */

class Solution {
    public int solve(int n, int e, int o, int t) {
        int years = 0;
        boolean even = true;
        double N = n;
        while (N <= t) {
            if (even == true) {
                N += (N * e) / 100;
            } else {
                N += (N * o) / 100;
            }
            even = !even;
            years++;
        }
        return years;
    }
}
