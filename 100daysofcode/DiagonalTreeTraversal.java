/* https://binarysearch.com/problems/Diagonal-Tree-Traversal  */

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
     Map<Integer, Integer> map;
    public int[] solve(Tree root) {
        map = new HashMap<Integer,Integer>();
        dfs(root, 0);
        int[] sumOfDiagonals = new int[map.size()];
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            sumOfDiagonals[entry.getKey()] = entry.getValue();
        }
        return sumOfDiagonals;
    }

    private void dfs(Tree root, int level) {
        if(root == null) return;
        int sum = map.getOrDefault(level, 0) + root.val;
        map.put(level, new Integer(sum));
        dfs(root.right, level);
        dfs(root.left, level + 1);
    }
}
