/* https://binarysearch.com/problems/Longest-Tree-Sum-Path-From-Root-to-Leaf */

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    List<Tree> longest = null;
    public int solve(Tree root) {
        //it's a two part problem.
        //1. which is the longest path
        //2. find sum
        int[] ans = dfs(root);
        return ans[1];
    }

    //arr[0] = no. of children arr[1] = sum of values of nodes
    private int[] dfs(Tree root) {
        if(root == null) return new int[]{0,0};
        int[] leftChild = dfs(root.left);
        int[] rightChild = dfs(root.right);
        if(leftChild[0] > rightChild[0]) {
            return new int[]{leftChild[0] + 1, leftChild[1] + root.val};
        } else if(leftChild[0] < rightChild[0]) {
            return new int[]{rightChild[0] + 1, rightChild[1] + root.val};
        } else {
            if(leftChild[1] >= rightChild[1]) {
                return new int[]{leftChild[0] + 1, leftChild[1] + root.val};
            } else {
                return new int[]{rightChild[0] + 1, rightChild[1] + root.val};
            }
        }
    }
}
