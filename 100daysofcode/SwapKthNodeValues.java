/* https://binarysearch.com/problems/Swap-Kth-Node-Values */

import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode node, int k) {
        int i = 0;
        LLNode fast = node;
        LLNode slow = node;
        while (i < k) {
            fast = fast.next;
            i++;
        }
        LLNode first = fast;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        LLNode last = slow;
        if (first == last)
            return node;

        int temp = first.val;
        first.val = last.val;
        last.val = temp;

        return node;
    }
}
