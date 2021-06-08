/* https://binarysearch.com/problems/Remove-Duplicates-in-Linked-List */

import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode node) {
        if (node == null || node.next == null)
            return node;
        Set<Integer> set = new HashSet<>();
        LLNode curr = node;
        LLNode prev = null;

        while (curr != null) {
            if (!set.contains(curr.val)) {
                set.add(curr.val);
                prev = curr;
                curr = curr.next;
            } else {
                curr = curr.next;
                prev.next = curr;
            }
        }
        return node;
    }
}
