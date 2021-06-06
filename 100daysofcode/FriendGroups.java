/* https://binarysearch.com/problems/Friend-Groups */

import java.util.*;

class Solution {
    int[] parent;
    public int solve(int[][] friends) {
        parent = new int[friends.length];
        int groups = 0;
        Arrays.fill(parent, -1);
        for(int i = 0; i < friends.length; i++) {
            int a = find(i);
            for(int j = 0; j < friends[i].length; j++) {
                int b = find(friends[i][j]);
                if(a != b) {
                    union(a, b);
                }
            }
        }
        for(int i = 0; i < parent.length; i++) {
            if(parent[i] < 1) groups++;
        }
        return groups;
    }

    private int find(int n) {
        while(parent[n] > 0) {
            n = parent[n];
        }
        return n;
    }

    private void union(int a, int b) {
        parent[a] = parent[a] + parent[b];
        parent[b] = a;
    }
}
