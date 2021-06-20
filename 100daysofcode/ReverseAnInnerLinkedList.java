/* https://binarysearch.com/problems/Reverse-an-Inner-Linked-List */

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode node, int i, int j) {
        LLNode dummy = new LLNode();
        dummy.val = -1;
        dummy.next = node;
        LLNode nodeBeforeList = dummy;
        int pos = 0;
        while(pos < i) {
            nodeBeforeList = nodeBeforeList.next;
            pos++;
        }
        LLNode workingPtr = nodeBeforeList.next;
        while(i < j) {
            LLNode nodeToBeExtracted = workingPtr.next;
            workingPtr.next = nodeToBeExtracted.next;
            nodeToBeExtracted.next = nodeBeforeList.next;
            nodeBeforeList.next = nodeToBeExtracted;
            i++;
        }
        return dummy.next;
    }
}
