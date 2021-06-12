/* https://binarysearch.com/problems/Palindromic-Tree */

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    List<Integer> list;
    public boolean solve(Tree root) {
        list = new ArrayList<>();
        dfs(root);
        int n = list.size();
        for(int i = 0; i < n/2; i++) {
            if(list.get(i) != list.get(n - i -1)) return false;
        }
        return true;
    }

    private void dfs(Tree root) {
        if(root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
