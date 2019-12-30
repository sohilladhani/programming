/* 21. Merge Two Sorted Lists */
/* Link- https://leetcode.com/problems/merge-two-sorted-lists */
/* Merge two sorted linked lists and return it as a new list. The new list 
 * should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
*/

class MergeList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedList = new ListNode(-1);
        ListNode mL = mergedList;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 == null) {
                mergedList.next = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l1 == null && l2 != null) {
                mergedList.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    mergedList.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    mergedList.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            } 
            mergedList = mergedList.next;
        }
        return mL.next;
    }

    public static void main (String args[]) {
        int list1 [] = {1,2,3};
        int list2 [] = {4,5,6};
        ListNode l1 = ListNodeUtils.createListFromIntegerArray(list1);
        ListNode l2 = ListNodeUtils.createListFromIntegerArray(list2);
        ListNodeUtils.printLinkedList(l1);
        ListNodeUtils.printLinkedList(l2);
        
        MergeList mergeListObj = new MergeList();
        ListNode mergedList = mergeListObj.mergeTwoLists(l1, l2);
        if (mergedList != null) {
            ListNodeUtils.printLinkedList(mergedList);
        }
    }
}
