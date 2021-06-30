/* https://binarysearch.com/problems/Linked-List-Jumps */

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode node) {
        LLNode temp = node;
        while (temp != null) {
            int k = temp.val;
            LLNode forward = temp;
            while (forward != null && k-- > 0) {
                forward = forward.next;
            }
            if (forward != null) {
                temp.next = forward;
            } else {
                temp.next = null;
                break;
            }
            temp = temp.next;
        }
        return node;
    }
}
