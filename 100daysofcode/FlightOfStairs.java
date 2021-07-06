/* https://binarysearch.com/problems/A-Flight-of-Stairs */

class Solution {
    public int solve(int n) {
        int fib1 = 1;
        int fib2 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = fib2;
            fib2 = (fib1 + fib2) % 1_000_000_007;
            fib1 = temp;
        }
        return fib2;
    }
}
