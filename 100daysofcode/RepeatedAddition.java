/* https://binarysearch.com/problems/Repeated-Addition */

class Solution {
    public int solve(int n) {
        if (n < 10)
            return n;
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return solve(sum);
    }
}
