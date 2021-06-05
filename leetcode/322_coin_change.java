/* 322. Coin Change
 * You are given coins of different denominations and a total amount of money 
 * amount. Write a function to compute the fewest number of coins that you need 
 * to make up that amount. If that amount of money cannot be made up by any 
 * combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

Note:
You may assume that you have an infinite number of each kind of coin.

Explanation: https://youtu.be/I-l6PBeERuc?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
*/

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] cache = new int[n + 1][amount + 1];
        for(int j = 0; j < amount + 1; j++) {
            /* INT_MAX - 1 because if we add coins in the choice 
             * diagram code part below, and we take INT_MAX instead
             * of INT_MAX-1, the result would be INT_MAX + 1 == -ve 
             * value, which is problematic. */
            cache[0][j] = Integer.MAX_VALUE-1;
        }
        for(int i = 0; i < n + 1; i++) {
            cache[i][0] = 0;
        }
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < amount + 1; j++) {
                if(coins[i-1] <= j) {
                    cache[i][j] = Math.min(1 + cache[i][j-coins[i-1]], cache[i-1][j]);
                } else {
                    cache[i][j] = cache[i-1][j];
                }
            }
        }
        if(cache[n][amount] == Integer.MAX_VALUE - 1) return -1;
        return cache[n][amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(cc.coinChange(coins, amount));
    }
}
