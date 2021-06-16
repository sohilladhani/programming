/* https://binarysearch.com/problems/Linked-List-Union */

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode ll0, LLNode ll1) {
        LLNode newHead = new LLNode();
        LLNode temp = newHead;
        while (ll0 != null && ll1 != null) {
            LLNode node = new LLNode();
            if (ll0.val < ll1.val) {
                node.val = ll0.val;
                temp.next = node;
                temp = temp.next;
                ll0 = ll0.next;
            } else if (ll1.val < ll0.val) {
                node.val = ll1.val;
                temp.next = node;
                temp = temp.next;
                ll1 = ll1.next;
            } else {
                node.val = ll0.val;
                temp.next = node;
                temp = temp.next;
                ll0 = ll0.next;
                ll1 = ll1.next;
            }
        }
        while (ll0 != null) {
            LLNode node = new LLNode();
            node.val = ll0.val;
            temp.next = node;
            temp = temp.next;
            ll0 = ll0.next;
        }
        while (ll1 != null) {
            LLNode node = new LLNode();
            node.val = ll1.val;
            temp.next = node;
            temp = temp.next;
            ll1 = ll1.next;
        }
        return newHead.next;
    }
}
