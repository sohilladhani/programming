/* https://binarysearch.com/problems/Subtree-with-Maximum-Average */

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    double highestAverage = 0;
    public double solve(Tree root) {
        dfs(root);
        return highestAverage;
    }

    private int[] dfs(Tree root) {
        if (root == null)
            return new int[] {0, 0};
        if (root.left == null && root.right == null) {
            highestAverage = Math.max(highestAverage, (double) root.val);
            return new int[] {root.val, 1};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int sum = left[0] + right[0] + root.val;
        int n = left[1] + right[1] + 1;
        double avg = (double) sum / n;
        highestAverage = Math.max(highestAverage, avg);
        return new int[] {sum, n};
    }
}
