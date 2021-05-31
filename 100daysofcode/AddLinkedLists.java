/* https://binarysearch.com/problems/Add-Linked-Lists */

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode l0, LLNode l1) {
        int sum = 0;
        int carry = 0;
        LLNode newHead = new LLNode();
        LLNode temp = newHead;
        newHead.val = Integer.MIN_VALUE;
        while (l0 != null && l1 != null) {
            newHead.next = new LLNode();
            sum = carry + l0.val + l1.val;
            newHead.next.val = sum % 10;
            carry = sum / 10;
            l0 = l0.next;
            l1 = l1.next;
            newHead = newHead.next;
        }
        while (l0 != null) {
            newHead.next = new LLNode();
            sum = carry + l0.val;
            newHead.next.val = sum % 10;
            carry = sum / 10;
            l0 = l0.next;
            newHead = newHead.next;
        }
        while (l1 != null) {
            newHead.next = new LLNode();
            sum = carry + l1.val;
            newHead.next.val = sum % 10;
            carry = sum / 10;
            l1 = l1.next;
            newHead = newHead.next;
        }
        if (carry != 0) {
            newHead.next = new LLNode();
            newHead.next.val = carry;
            newHead = newHead.next;
        }
        newHead.next = null;
        return temp.next;
    }
}
