/* https://binarysearch.com/problems/Inverse-Factorial */

class Solution {
    public int solve(int a) {
        int i = 1;
        while (a > 1) {
            if (a % i != 0)
                return -1;
            a = a / i;
            i++;
        }
        return i - 1;
    }
}
