/* https://binarysearch.com/problems/Tree-Pruning */

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public Tree solve(Tree root) {
        if(root == null) return root;
        return dfs(root, 0);
    }

    private Tree dfs(Tree root, int val) {
        if(root == null) return null;
        if(isPrunable(root)) return null;
        root.left = dfs(root.left, val);
        root.right = dfs(root.right, val);
        if(isPrunable(root)) return null;
        return root;
    }

    private boolean isPrunable(Tree root) {
        if(root.left == null && root.right == null && root.val == 0) return true;
        return false;
    }
}
