/* Question at https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list*/

Node* Insert(Node *head,int data)
{
  // Complete this method
    Node *new_node = new Node;
    new_node->data = data;
    new_node->next = NULL;
    if(!head) return new_node;
    Node *temp = head;
    while(temp->next) {
        temp = temp->next;
    }
    
    temp->next = new_node;
    return head;
}
