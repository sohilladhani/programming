/* https://binarysearch.com/problems/Largest-Root-to-Leaf-Sum */

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int sum = 0;
    public int solve(Tree root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(Tree root, int parentVal) {
        if (root == null) {
            return;
        }
        sum = Math.max(sum, root.val + parentVal);
        dfs(root.left, root.val + parentVal);
        dfs(root.right, root.val + parentVal);
    }
}
