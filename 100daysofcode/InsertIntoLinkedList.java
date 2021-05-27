/* https://binarysearch.com/problems/Insert-Into-Linked-List */

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode head, int pos, int val) {
        LLNode newNode = new LLNode();
        newNode.val = val;
        if(pos == 0) {
            newNode.next = head;
            return newNode;
        }
        LLNode after = head; LLNode before = null;
        while(pos > 0) {
            before = after;
            pos--;
            after = after.next;
        }
        newNode.next = after;
        before.next = newNode;
        return head;
    }
}
