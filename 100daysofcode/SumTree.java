/* https://binarysearch.com/problems/Sum-Tree */

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    boolean ans = true;
    public boolean solve(Tree root) {
        dfs(root);
        return ans;
    }

    private void dfs(Tree root) {
        if(root == null) return;
        int childrenSum = 0;
        if(root.left != null) {
            childrenSum += root.left.val;
        }
        if(root.right != null) {
            childrenSum += root.right.val;
        }

        if(!isLeaf(root) && root.val != childrenSum) {
            ans = false;
            return;
        }
        dfs(root.left);
        dfs(root.right);
    }

    private boolean isLeaf(Tree node) {
        if(node.left == null && node.right == null) return true;
        return false;
    } 
}
