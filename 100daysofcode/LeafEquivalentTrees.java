/* https://binarysearch.com/problems/Leaf-Equivalent-Trees */

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public boolean solve(Tree root0, Tree root1) {
        List<Integer> leftSeq = new ArrayList<>();
        List<Integer> rightSeq = new ArrayList<>();
        dfs(root0, leftSeq);
        dfs(root1, rightSeq);
        return leftSeq.equals(rightSeq);
    }

    private void dfs(Tree root, List<Integer> list) {
        if (root == null)
            return;
        if (isLeaf(root) == true)
            list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }

    private boolean isLeaf(Tree node) {
        return node.left == null && node.right == null;
    }
}
