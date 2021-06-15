import java.util.*;

class Solution {
    public int[][] solve(int[][] graph) {
        Map<Integer, List> original = new HashMap<>();
        Map<Integer, List> reverse = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            List<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                innerList.add(graph[i][j]);
            }
            original.put(i, innerList);
        }

        for (Map.Entry<Integer, List> entry : original.entrySet()) {
            List<Integer> innerList = entry.getValue();
            for (int ele : innerList) {
                reverse.put(ele, new ArrayList<>());
            }
        }

        for (Map.Entry<Integer, List> entry : original.entrySet()) {
            List<Integer> innerList = entry.getValue();
            for (int ele : innerList) {
                reverse.get(ele).add(entry.getKey());
            }
        }

        int[][] ans = new int[graph.length][];
        for (Map.Entry<Integer, List> entry : reverse.entrySet()) {
            List<Integer> innerList = entry.getValue();
            int idx = 0;
            int[] innerArr = new int[entry.getValue().size()];
            for (int ele : innerList) {
                innerArr[idx++] = ele;
            }
            ans[entry.getKey()] = innerArr;
        }
        for (int i = 0; i < graph.length; i++) {
            if (ans[i] == null) {
                ans[i] = new int[0];
            }
        }
        return ans;
    }
}
