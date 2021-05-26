/* https://binarysearch.com/problems/Leaves-in-Same-Level */

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    HashSet<Integer> set;
    public boolean solve(Tree root) {
        set = new HashSet<>();
        dfs(root, 0);
        return set.size() == 1;
    }

    private void dfs(Tree root, int level) {
        if(root == null) return;
        if(root.left == null && root.right == null) set.add(level);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}
