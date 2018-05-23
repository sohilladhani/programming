/* Question at https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists */

int FindMergeNode(Node *headA, Node *headB)
{   
    //length of list A
    Node *head = headA;
    int lengthA = 0;
    while(head) {
        lengthA++;
        head = head->next;
    }
    
    head = headB;
    int lengthB = 0;
    while(head) {
        lengthB++;
        head = head->next;
    }
    
    int d = lengthA - lengthB;
    
    if(lengthB>lengthA) {
        Node *temp = headA;
        headA = headB;
        headB = temp;
        d = lengthB - lengthA;
    }
    
    while(d) {
        headA = headA->next;
        d--;
    }
    while(headA && headB) {
        if(headA == headB) {
            return headA->data;
        }
        headA = headA->next;
        headB = headB->next;
    }
    return -1;
}
