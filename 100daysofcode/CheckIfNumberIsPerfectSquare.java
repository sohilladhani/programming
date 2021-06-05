/* https://binarysearch.com/problems/Check-if-Number-Is-Perfect-Square */

class Solution {
    public boolean solve(int n) {
        if(n == 0 || n == 1) return true;
        long low = 2; long high = n/2;

        while(low <= high) {
            long mid = low + (high - low)/2;
            if(mid * mid == n) return true;
            else if(mid * mid > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
