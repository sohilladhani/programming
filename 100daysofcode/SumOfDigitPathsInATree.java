/* https://binarysearch.com/problems/Sum-of-Digit-Paths-in-a-Tree */

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    int sum = 0;
    int BASE = 10;
    public int solve(Tree root) {
        calculateSum(root, 0);
        return sum;
    }

    private void calculateSum(Tree root, int val) {
        if(root == null) return;
        int localSum = BASE*val + root.val;
        if(root.left == null && root.right == null) {
            sum += localSum;
        }
        if(root.left != null) calculateSum(root.left, localSum);
        if(root.right != null) calculateSum(root.right, localSum);
    }
}
