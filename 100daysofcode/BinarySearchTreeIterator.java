/* https://binarysearch.com/problems/Binary-Search-Tree-Iterator */

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class BSTIterator {
    List<Integer> sortedList;
    int i;
    public BSTIterator(Tree root) {
        sortedList = new ArrayList<>();
        dfs(root);
        i = 0;
    }

    private void dfs(Tree root) {
        if (root == null)
            return;
        dfs(root.left);
        sortedList.add(root.val);
        dfs(root.right);
    }

    public int next() {
        return sortedList.get(i++);
    }

    public boolean hasnext() {
        return i < sortedList.size();
    }
}
