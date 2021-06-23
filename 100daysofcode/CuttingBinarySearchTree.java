/* https://binarysearch.com/problems/Cutting-Binary-Search-Tree */

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public Tree solve(Tree root, int lo, int hi) {
        if (root == null)
            return null;
        root.left = solve(root.left, lo, hi);
        root.right = solve(root.right, lo, hi);
        if (root.val < lo || root.val > hi) {
            if (root.left != null)
                return root.left;
            else if (root.right != null)
                return root.right;
            else
                return null;
        }
        return root;
    }
}
