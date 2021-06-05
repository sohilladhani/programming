/* https://binarysearch.com/problems/Binary-Search-Tree-Validation */
/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    class Pair {
        boolean isBST;
        int max;
        int min;

        Pair(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
        Pair() {
        }
    }

    public boolean solve(Tree root) {
        return dfs(root).isBST;
    }

    private Pair dfs(Tree root) {
        if (root == null) {
            return new Pair(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Pair lp = dfs(root.left);
        Pair rp = dfs(root.right);
        Pair p = new Pair();
        p.isBST = lp.isBST && rp.isBST && root.val >= lp.max && root.val <= rp.min;
        p.min = Math.min(root.val, Math.min(lp.min, rp.min));
        p.max = Math.max(root.val, Math.max(lp.max, rp.max));
        return p;
    }
}
