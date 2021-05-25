/* https://binarysearch.com/problems/Rotate-Linked-List-by-K */

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode node, int k) {
        if (k == 0)
            return node;
        LLNode temp = node;
        LLNode fast = node;
        LLNode slow = node;
        LLNode prev = null;
        while (k-- > 0) {
            fast = fast.next;
        }
        if (fast == null)
            return node;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        LLNode newHead = slow;
        prev.next = null;
        temp = newHead;
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        if (temp != null)
            temp.next = node;
        return newHead;
    }
}
