/* https://binarysearch.com/problems/Sum-of-the-Deepest-Nodes */

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public int solve(Tree root) {
        if (root == null)
            return 0;
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        Queue<Tree> bfs = new LinkedList<>();
        bfs.add(root);
        list.add(root.val);
        bfs.add(null);
        list.add(Integer.MIN_VALUE);
        while (!bfs.isEmpty()) {
            Tree node = bfs.poll();
            if (node == null) {
                list.add(Integer.MIN_VALUE);
                bfs.add(null);
                if (bfs.peek() == null)
                    break;
            } else {
                if (node.left != null) {
                    bfs.add(node.left);
                    list.add(node.left.val);
                }
                if (node.right != null) {
                    bfs.add(node.right);
                    list.add(node.right.val);
                }
            }
        }
        int i = list.size() - 1;
        while (list.get(i) == Integer.MIN_VALUE) i--;
        while (i >= 0 && list.get(i) != Integer.MIN_VALUE) {
            ans += list.get(i--);
        }
        return ans;
    }
}
