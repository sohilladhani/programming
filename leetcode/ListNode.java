/*  Definition for singly-linked list. */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static ListNode createListFromIntegerArray(int elems[]) {
        int elemsLength = elems.length;
        if (elemsLength <= 0) return null;
        ListNode head = new ListNode(elems[0]);
        ListNode dummyHead = head;
        for (int i = 1; i < elemsLength; i++) {
            head.next = new ListNode(elems[i]); 
            head = head.next;
        }
        return dummyHead;
    }
     
}

