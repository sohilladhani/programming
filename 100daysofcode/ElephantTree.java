https://binarysearch.com/problems/Elephant-Tree
/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public Tree solve(Tree root) {
        helper(root);
        return root;
    }

    private int helper(Tree root) {
        if(root == null) return 0;
        return root.val += helper(root.left) + helper(root.right);
    }
}
