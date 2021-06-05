/* https://binarysearch.com/problems/Linked-List-Folding */

import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode node) {
        //1. Reverse 2nd half of list
        //2. Create a new list
        //3. Add elems of 1st and 2nd half(which is reversed)
        //4. Reverse the new list
        List<Integer> newList = new ArrayList<>();
        LLNode fast = node; LLNode slow = node; LLNode prev = null;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        //first list --> head to prev
        //2nd list --> slow to fast
        //Reverse 2nd one
        LLNode pre = null; LLNode curr = slow; LLNode next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        //new head
        slow = pre;

        while(node != null && slow != null) {
            newList.add(node.val + slow.val);
            node = node.next;
            slow = slow.next;
        }
        if(slow != null) {
            newList.add(slow.val);
        }
        if(node!=null) {
            newList.add(node.val);
        }
        Collections.reverse(newList);
        LLNode dummyHead = new LLNode(); LLNode newHead = dummyHead; LLNode temp = null;
        for(int ele: newList) {
            temp = new LLNode();
            temp.val = ele;
            newHead.next = temp;
            newHead = newHead.next;
        }
        return dummyHead.next;
    }
}
