/* https://binarysearch.com/problems/Binary-Tree-to-Linked-List */

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    List<Integer> list = null;
    public LLNode solve(Tree root) {
        list = new ArrayList<>();
        LLNode ans = new LLNode(); LLNode newList = ans; LLNode temp = null;
        inorder(root);
        for(int ele: list) {
            temp = new LLNode();
            temp.val = ele;
            newList.next = temp;
            newList = newList.next;
        }
        return ans.next;
    }

    private void inorder(Tree root) {
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
