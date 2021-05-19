/* https://binarysearch.com/problems/Count-BST-Nodes-in-a-Range */
/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int ans = 0;
    public int solve(Tree root, int lo, int hi) {
        helper(root, lo, hi);
        return ans;
    }

    private void helper(Tree root, int low, int high) {
        if(root == null) return;
        helper(root.left, low, high);
        if(root.val >= low && root.val <= high) ans++;
        helper(root.right, low, high);
    }
}
