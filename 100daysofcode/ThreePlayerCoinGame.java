/* https://binarysearch.com/problems/Three-Player-Coin-Game */

import java.util.*;

class Solution {
    public int solve(int[] piles) {
        Arrays.sort(piles);
        int firstHighest = piles.length - 1;
        int secondHighest = firstHighest - 1;
        int firstLowest = 0;
        int coins = 0;
        while (firstLowest < secondHighest) {
            coins += piles[secondHighest];
            firstLowest++;
            firstHighest = firstHighest - 2;
            secondHighest = secondHighest - 2;
        }
        return coins;
    }
}
