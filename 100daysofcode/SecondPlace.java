/* https://binarysearch.com/problems/Second-Place */

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    TreeSet<Integer> treeSet;
    public int solve(Tree root) {
        treeSet = new TreeSet();
        dfs(root, 0);
        treeSet.pollLast();
        return treeSet.pollLast();
    }

    private void dfs(Tree root, int level) {
        if(root == null) return;
        if(root.left == null && root.right == null)
            treeSet.add(level);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}
