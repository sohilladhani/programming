/* https://binarysearch.com/problems/Bitwise-AND-of-Range-of-Numbers */

class Solution {
    public int solve(int start, int end) {
        int ans = 0 | start;
        while(++start <= end) {
            ans = ans & start;
        }
        return ans;
    }
}
