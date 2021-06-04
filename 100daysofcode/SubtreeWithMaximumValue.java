/* https://binarysearch.com/problems/Subtree-with-Maximum-Value */

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int maxOfAll = Integer.MIN_VALUE;
    public int solve(Tree root) {
        dfs(root);
        return maxOfAll < 0 ? 0 : maxOfAll;
    }

    private int dfs(Tree root) {
        if (root == null)
            return 0;
        int sum = root.val + dfs(root.left) + dfs(root.right);
        maxOfAll = Math.max(maxOfAll, sum);
        return sum;
    }
}
