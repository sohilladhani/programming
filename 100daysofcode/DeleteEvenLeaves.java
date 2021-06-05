/* https://binarysearch.com/problems/Delete-Even-Leaves */

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public Tree solve(Tree root) {
        return dfs(root);
    }

    private Tree dfs(Tree root) {
        if(root == null) return null;
        if(root.left == null && root.right == null && root.val % 2 ==0) {
            return null;
        }
        if(dfs(root.left) == null) root.left = null;
        if(dfs(root.right) == null) root.right = null;
        if(root.left == null && root.right == null && root.val % 2 ==0) {
            return null;
        }
        return root;
    }
}
