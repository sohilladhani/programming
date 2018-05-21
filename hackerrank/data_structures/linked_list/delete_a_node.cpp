/* Question at https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list */

Node* Delete(Node *head, int position)
{
    if(!head) return head;
    //single element
    if(!head->next) return NULL;
    
    //multiple elements
    Node *remove;
    // remove current head
    if(position == 0) {
        remove = head;
        head = head->next;
    } else {
        int pos = 0;
        Node *ptr = head;
        while(pos < position-1) {
            ptr = ptr->next;
            pos++;
        }
        remove = ptr->next;
        ptr->next = ptr->next->next;
    }
    delete remove;
    return head;
}
