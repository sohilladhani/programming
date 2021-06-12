/* https://binarysearch.com/problems/Hamming-Distance */

class Solution {
    public int solve(int x, int y) {
        int z = x ^ y;
        int ans = 0;
        while(z != 0) {
            if(z % 2 == 1) ans++;
            z = z/2;
        }
        return ans;
    }
}
