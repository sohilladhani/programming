https://binarysearch.com/problems/Sum-of-Right-Leaves
/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int ans = 0;
    public int solve(Tree root) {
        //check if it's leaf && it's right child
        //if so, add root.val to global
        helper(root, false);
        return ans;
    }

    private void helper(Tree root, boolean isRight) {
        if(root == null) return;
        if(root.left == null && root.right == null && isRight == true) {
            ans+=root.val;
        } else {
            helper(root.left, false);
            helper(root.right, true);
        }
    }
}
