/* 1290. Convert Binary Number in a Linked List to Integer */
/* Problem: Given head which is a reference node to a singly-linked list. The 
 * value of each node in the linked list is either 0 or 1. The linked list holds
 * the binary representation of a number. Return the decimal value of the number
 * in the linked list. */

class ConvertBinaryToInteger {
    public int getDecimalValue(ListNode head) {
        if (null == head) {
            return -1;
        }
        int decimalValue = 0;
        while (head != null) {
            decimalValue = decimalValue << 1;
            decimalValue |= head.val;
            head = head.next;
        }
        return decimalValue;
    }

    public static void main (String args[]) {
        int elems[] = {1,0,0,1,0,0,1,1,1,0,0,0,0,0,0};
        ListNode head = ListNodeUtils.createListFromIntegerArray(elems);
        ConvertBinaryToInteger solution = new ConvertBinaryToInteger();
        System.out.println("Decimal value: " + solution.getDecimalValue(head));
    }
}
