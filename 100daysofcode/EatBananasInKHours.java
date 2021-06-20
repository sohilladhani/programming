/* https://binarysearch.com/problems/Eat-Bananas-in-K-Hours */

class Solution {
    public int solve(int[] piles, int k) {
        int r = 1;
        while (r <= k) {
            if (pilesEatable(piles, k, r) == true) {
                break;
            }
            r++;
        }
        return r;
    }

    private boolean pilesEatable(int[] piles, int k, int r) {
        int hours = 0;
        for (int bananas : piles) {
            hours += (bananas / r) + ((bananas % r == 0) ? 0 : 1);
        }
        return hours <= k;
    }
}
