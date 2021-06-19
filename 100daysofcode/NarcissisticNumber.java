/* https://binarysearch.com/problems/Narcissistic-Number */

class Solution {
    public boolean solve(int n) {
        int digits = 0;
        int N = n;
        int sum = 0;
        while(n != 0) {
            digits++;
            n = n/10;
        }
        n = N;
        while(N != 0) {
            sum += Math.pow((N%10), digits);
            N = N/10;
        }
        return sum == n;
    }
}
