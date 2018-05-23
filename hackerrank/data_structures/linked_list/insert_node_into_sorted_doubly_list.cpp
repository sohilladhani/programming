/* Question at https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list */

Node* insertAtPosition (Node *head, int pos, Node* new_node) {
    Node *ptr = head;
    if (pos == 0) {
        new_node->next = head;
        head->prev = new_node;
        head = new_node;
    } else {
        while(--pos) {
            ptr = ptr->next;
        }
        new_node->next = ptr->next;
        new_node->prev = ptr;
        ptr->next = new_node;
    }  
    
    return head;
}

Node* SortedInsert(Node *head,int data)
{
    Node *new_node = new Node;
    new_node->data = data;
    new_node->next = new_node->prev = NULL;
    //empty list?
    if(!head) {
        head = new_node;
    } else {
        //determine the position at which the node should be inserted.
        int pos = 0;
        Node *ptr = head;
        while(ptr && ptr->data <= data){
            ptr = ptr->next;
            pos++;
        }
        
        head = insertAtPosition(head, pos, new_node);
    }
    return head;
}
