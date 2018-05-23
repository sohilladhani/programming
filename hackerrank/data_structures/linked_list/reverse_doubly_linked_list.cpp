Node* Reverse(Node* head)
{
    if(head && head->next) {
        Node* curr = head;
        Node* prev_node = NULL;
        while(curr) {
            prev_node = curr->prev;
            curr->prev = curr->next;
            curr->next = prev_node;
            curr = curr->prev;
        }
        if(prev_node) prev_node = prev_node->prev;
        head = prev_node;
    }
    return head;
}
