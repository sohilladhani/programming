/* https://binarysearch.com/problems/Next-Node-on-Its-Right */

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public Tree solve(Tree tree, int target) {
        if (tree == null || (tree.left == null && tree.right == null))
            return null;
        Queue<Tree> bfs = new LinkedList<>();

        bfs.add(tree);
        bfs.add(null);
        while (!bfs.isEmpty()) {
            Tree node = bfs.remove();
            if (node == null) {
                bfs.add(null);
                if (bfs.peek() == null)
                    break;
            } else {
                if (node.val == target) {
                    if (!bfs.isEmpty() && bfs.peek() != null)
                        return bfs.remove();
                }
            }

            if (node != null && node.left != null)
                bfs.add(node.left);
            if (node != null && node.right != null)
                bfs.add(node.right);
        }
        return null;
    }
}
