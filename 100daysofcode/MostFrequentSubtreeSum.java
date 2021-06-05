/* https://binarysearch.com/problems/Most-Frequent-Subtree-Sum */

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
    public int solve(Tree root) {
        map = new HashMap<>();
        dfs(root);
        int maxFrequency = 0;
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(maxFrequency < entry.getValue()) {
                maxFrequency = entry.getValue();
                ans = entry.getKey();
            }
        }
        return ans;
    }

    private int dfs(Tree root) {
        if(root == null) return 0;
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        int sum = leftSum + rightSum + root.val;
        map.put(sum, new Integer(map.getOrDefault(sum, 0) + 1));
        return sum;
    }
}
