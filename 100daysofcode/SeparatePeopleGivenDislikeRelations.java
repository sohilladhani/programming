/* https://binarysearch.com/problems/Separate-People-Given-Dislike-Relations */

import java.util.*;

class Solution {
    public boolean solve(int n, int[][] enemies) {
        boolean[] visited = new boolean[n];
        int[] color = new int[n];
        Arrays.fill(color, -1);
        boolean ans = true;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] enemy : enemies) {
            graph.get(enemy[0]).add(enemy[1]);
            graph.get(enemy[1]).add(enemy[0]);
        }

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            int ele = entry.getKey();
            if (visited[ele] == false) {
                visited[ele] = true;
                color[ele] = 0;
                ans = ans && isBipartite(graph, ele, visited, color);
            }
        }
        return ans;
    }

    private boolean isBipartite(
        Map<Integer, List<Integer>> graph, int node, boolean[] visited, int[] color) {
        for (int child : graph.get(node)) {
            if (visited[child] == false) {
                visited[child] = true;
                if (color[child] != -1)
                    return false;
                color[child] = 1 - color[node];
                if (isBipartite(graph, child, visited, color) == false)
                    return false;
            }
            if (color[node] == color[child])
                return false;
        }
        return true;
    }
}
