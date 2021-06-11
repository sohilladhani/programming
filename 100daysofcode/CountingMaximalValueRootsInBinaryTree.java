/* https://binarysearch.com/problems/Counting-Maximal-Value-Roots-in-Binary-Tree */

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int count = 0;
    public int solve(Tree root) {
        dfs(root);
        return count;
    }

    private int dfs(Tree root) {
        if (root == null)
            return Integer.MIN_VALUE;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (root.val >= left && root.val >= right) {
            count++;
        }
        return Math.max(root.val, Math.max(left, right));
    }
}
