/* https://binarysearch.com/problems/Only-Child */

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int onlyChilds = 0;
    public int solve(Tree root) {
        if (root == null)
            return 0;
        dfs(root.left, root.left != null, root.right != null);
        dfs(root.right, root.left != null, root.right != null);
        return onlyChilds;
    }

    private void dfs(Tree root, boolean leftPresent, boolean rightPresent) {
        if (root == null)
            return;
        if (leftPresent == false || rightPresent == false) {
            onlyChilds++;
        }
        dfs(root.left, root.left != null, root.right != null);
        dfs(root.right, root.left != null, root.right != null);
    }
}
