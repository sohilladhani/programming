/* https://binarysearch.com/problems/Twin-Trees */

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public boolean solve(Tree root0, Tree root1) {
        return areIdentical(root0, root1);
    }

    private boolean areIdentical(Tree root0, Tree root1) {
        if (root0 == null && root1 == null)
            return true;
        if (root0 == null || root1 == null)
            return false;
        return root0.val == root1.val && areIdentical(root0.left, root1.left)
            && areIdentical(root0.right, root1.right);
    }
}
