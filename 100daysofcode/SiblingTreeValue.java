/* https://binarysearch.com/problems/Sibling-Tree-Value */
/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int ans = 0;
    public int solve(Tree root, int k) {
        dfs(root, k);
        return ans;
    }

    private int dfs(Tree root, int k) {
        if (root == null)
            return Integer.MAX_VALUE;
        if (root.val == k)
            return k;
        if (root.val > k) {
            if (k == dfs(root.left, k))
                ans = root.right.val;
        } else {
            if (k == dfs(root.right, k))
                ans = root.left.val;
        }
        return root.val;
    }
}
