/* Question at https://www.hackerrank.com/challenges/compare-two-linked-lists */

int CompareLists(Node *headA, Node* headB)
{ 
    int identical = 1;
    
    int len_A = 0;
    int len_B = 0;
    Node *temp = headA;
    while(temp) {
        len_A++;
        temp = temp->next;
    }
    
    temp = headB;
    while(temp) {
        len_B++;
        temp = temp->next;
    }
    
    if(len_A == len_B) {
        while(headA && headB) {
            if(!(headA->data ^ headB->data)) identical &= 1;
            else identical &= 0;
            headA = headA->next;
            headB = headB->next;
        }
    } else identical = 0;
    
    return identical;
}
