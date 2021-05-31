/* https://binarysearch.com/problems/Subtree */

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public boolean solve(Tree root, Tree target) {
        if (root == null)
            return target == null;
        if (areIdentical(root, target) == true)
            return true;
        else
            return solve(root.left, target) || solve(root.right, target);
    }

    private boolean areIdentical(Tree t1, Tree t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        return t1.val == t2.val && areIdentical(t1.left, t2.left)
            && areIdentical(t1.right, t2.right);
    }
}
