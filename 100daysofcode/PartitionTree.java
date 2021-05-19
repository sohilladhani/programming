/* https://binarysearch.com/problems/Partition-Tree */
/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int[] ans = null;

    public int[] solve(Tree root) {
        ans = new int[2];
        helper(root);
        return ans;
    }

    private void helper(Tree root) {
        if(root == null) return;
        if(root.left == null && root.right == null) ans[0] = ans[0]+1;
        else ans[1] = ans[1]+1;
        helper(root.left);
        helper(root.right);
    }
}
