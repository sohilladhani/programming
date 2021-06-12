/* https://binarysearch.com/problems/Leftmost-Deepest-Tree-Node */

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
        Queue<Tree> bfs = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        bfs.add(root);
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
                list.add(node.val);
                if (node.left != null)
                    bfs.add(node.left);
                if (node.right != null)
                    bfs.add(node.right);
            }
        }
        int i = list.size() - 1;
        while (list.get(i) == Integer.MIN_VALUE) i--;
        while (list.get(i) != Integer.MIN_VALUE) i--;
        return list.get(i + 1);
    }
}
