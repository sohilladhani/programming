/* Question at https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list */

Node* InsertNth(Node *head, int data, int position)
{
  // Complete this method only
  // Do not write main function. 
    Node *new_node = new Node;
    new_node->data = data;
    new_node->next = NULL;
    if(!head) return new_node;
    
    if(position == 0) {
        new_node->next = head;
        head = new_node;
    } else {
        int pos = 0;
        Node *ptr = head;
        while(pos < position-1) {
            ptr = ptr->next;
            pos++;
        }
        new_node->next = ptr->next;
        ptr->next = new_node;
    } 
    
    return head;
}
