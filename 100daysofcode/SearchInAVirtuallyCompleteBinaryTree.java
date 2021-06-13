/* https://binarysearch.com/problems/Search-in-a-Virtually-Complete-Binary-Tree */

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public boolean solve(Tree root, int target) {
        Queue<Tree> bfs = new LinkedList<>();
        bfs.add(root);
        while(!bfs.isEmpty()) {
            Tree node = bfs.poll();
            if(node.val == target) return true;
            if(node.left != null) bfs.add(node.left);
            if(node.right != null) bfs.add(node.right);
        }
        return false;
    }
}
