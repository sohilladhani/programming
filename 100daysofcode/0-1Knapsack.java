/* https://binarysearch.com/problems/0-1-Knapsack */

import java.util.*;

class Solution {
    int[][] cache;
    public int solve(int[] weights, int[] values, int capacity) {
        cache = new int[weights.length+1][capacity+1];
        for(int i = 1; i < cache.length; i++) {
            for(int j = 1; j < cache[i].length; j++) {
                if(weights[i-1] <= j) {
                    cache[i][j] = Math.max(cache[i-1][j], 
                                  values[i-1] + cache[i-1][j-weights[i-1]]);
                } else {
                    cache[i][j] = cache[i-1][j];
                }
            }
        }
        return cache[weights.length][capacity];
    }
}
