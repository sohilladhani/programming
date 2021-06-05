/* https://binarysearch.com/problems/Univalue-Tree */

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public boolean solve(Tree root) {
        if (root == null)
            return true;
        return dfs(root, root.val);
    }

    private boolean dfs(Tree root, int value) {
        if (root == null)
            return true;
        return root.val == value && 
          	   dfs(root.left, value) && 
          	   dfs(root.right, value);
    }
}
