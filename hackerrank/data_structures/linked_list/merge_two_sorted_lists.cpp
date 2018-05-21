/* Question at https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists */

Node* MergeLists(Node *headA, Node* headB)
{
    if(!headA && !headB) return headA;
    if(headA && !headB) return headA;
    if(!headA && headB) return headB;
    
    Node* new_node;
    Node* current;
    Node* head = new Node;
    if(headA->data <= headB->data) {
        head->data = headA->data;
        headA = headA->next;
    } else {
        head->data = headB->data;
        headB = headB->next;
    }
    head->next = NULL;
    current = head;
    
    while(headA || headB) {
        if(!headA) {
            new_node = new Node;
            new_node->next = NULL;
            new_node->data = headB->data;
            headB = headB->next;
        } else if(!headB) {
            new_node = new Node;
            new_node->next = NULL;
            new_node->data = headA->data;
            headA = headA->next;
        } else {
            if(headA->data <= headB->data) {
            new_node = new Node;
            new_node->data = headA->data;
            new_node->next = NULL;
            headA = headA->next;
        } else {
                new_node = new Node;
                new_node->data = headB->data;
                new_node->next = NULL;
                headB = headB->next;
            }
        }
        
        current->next = new_node;
        current = new_node;
    }
    return head;
}
