/* https://binarysearch.com/problems/Linked-List-Intersection */

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode l0, LLNode l1) {
        LLNode newHead = new LLNode();
        LLNode temp = newHead;
        while(l0 != null && l1 != null) {
            if(l0.val < l1.val) l0 = l0.next;
            else if(l0.val > l1.val) l1 = l1.next;
            else {
                newHead.next = new LLNode();
                newHead.next.val = l0.val;
                newHead = newHead.next;
                l0 = l0.next;
                l1 = l1.next;
            }
        }
        newHead.next = null;
        return temp.next;
    }
}
