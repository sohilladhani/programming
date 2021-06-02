/* https://binarysearch.com/problems/Poly-Knapsack */

class Solution {
    public int solve(int[] weights, int[] values, int capacity) {
        int[][] cache = new int[weights.length+1][capacity+1];

        for(int i = 1; i < cache.length; i++) {
            for(int j = 1; j < cache[i].length; j++) {
                if(weights[i-1] <= j) {
                    cache[i][j] = Math.max(values[i-1] + cache[i][j-weights[i-1]],
                                           cache[i-1][j]);
                } else {
                    cache[i][j] = cache[i-1][j];
                }
            }
        }
        return cache[weights.length][capacity];
    }
}
