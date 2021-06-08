/* https://binarysearch.com/problems/Sum-of-Nodes-with-Even-Grandparent-Values */

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
        dfs(root, -1, -1);
        return sum;
    }

    private void dfs(Tree root, int parentValue, int grandParentValue) {
        if (root == null)
            return;
        if (grandParentValue % 2 == 0) {
            sum += root.val;
        }
        dfs(root.left, root.val, parentValue);
        dfs(root.right, root.val, parentValue);
    }
}
