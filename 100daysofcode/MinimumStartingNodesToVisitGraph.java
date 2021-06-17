/* https://binarysearch.com/problems/Minimum-Starting-Nodes-to-Visit-Graph */

import java.util.*;

class Solution {
    public int[] solve(int[][] edges) {
        // find total nodes first
        Set<Integer> set = new HashSet<>();
        int[] indegrees;
        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                set.add(edges[i][j]);
            }
        }
        indegrees = new int[set.size()];
        for (int i = 0; i < edges.length; i++) {
            indegrees[edges[i][1]]++;
        }
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0)
                vertices.add(i);
        }
        int[] ans = new int[vertices.size()];
        int idx = 0;
        for (int ele : vertices) {
            ans[idx++] = ele;
        }
        Arrays.sort(ans);
        return ans;
    }
}
