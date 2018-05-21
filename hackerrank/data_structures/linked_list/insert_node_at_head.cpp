/* Question at https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list*/

Node* Insert(Node *head,int data)
{
    Node *new_node = new Node;
    new_node->data = data;
    new_node->next = NULL;
    if(!head) return new_node;
       
    new_node->next = head;
    head = new_node;
    return head;
}
