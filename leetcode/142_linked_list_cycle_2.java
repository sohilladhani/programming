/* 142 Linked List Cycle II-https://leetcode.com/problems/linked-list-cycle-ii*/
/* Given a linked list, return the node where the cycle begins. If there is no 
 * cycle, return null.

To represent a cycle in the given linked list, we use an integer pos which 
represents the position (0-indexed) in the linked list where tail connects to. 
If pos is -1, then there is no cycle in the linked list.

Note: Do not modify the linked list.

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the
second node.

Example 2:

Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:

Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode fast = head; fast = head.next.next;
        ListNode slow = head; slow = head.next;
        if (fast == slow) return fast;

        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
    public static void main(String args[]) throws IOException {
        String inputFile = "141_linked_list_cycle.input";
        File file = new File(inputFile);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            int listElems[] = new int[N];
            for (int i = 0; i < N; i++) {
                listElems[i] = Integer.parseInt(br.readLine().trim());
            }
            int pos = Integer.parseInt(br.readLine().trim());
            System.out.println("pos: " + pos);
 
            ListNode list = ListNodeUtils.createListFromIntegerArray(listElems);
            ListNode tail = list;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = ListNodeUtils.getNodeAtPosition(list, pos);
            ListNodeUtils.printLinkedList(list);
            LinkedListCycle2 LLC = new LinkedListCycle2();
            ListNode cycleElem = LLC.detectCycle(list);
            if (cycleElem != null) {
                System.out.println(cycleElem.val);
            }
        }
    }
}
