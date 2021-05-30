/* https://binarysearch.com/problems/Height-Balanced-Tree */

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public boolean solve(Tree root) {
        int bh = dfs(root)[0];
        return bh == 1;
    }

    private int[] dfs(Tree root) {
        if(root == null) return new int[] {1, -1};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int height =  1 + Math.max(left[1], right[1]);
        boolean balancedHeight = Math.abs(left[1] - right[1]) <= 1;
        balancedHeight = balancedHeight && left[0] == 1 && right[0] == 1;
        int bh = 0;
        if(balancedHeight == true) bh = 1;
        return new int[] {bh, height};
    }
}
