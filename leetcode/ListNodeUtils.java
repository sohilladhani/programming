public class ListNodeUtils {

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

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "-->");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static ListNode getNodeAtPosition(ListNode head, int pos) {
        if (head == null || pos < 0) {
            return null;
        }
        
        while (pos != 0) {
            head = head.next;
            pos--;
        }
        return head;
    }
}
