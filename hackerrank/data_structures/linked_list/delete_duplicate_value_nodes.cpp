/* Question at https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list */

Node* RemoveDuplicates(Node *head)
{
    if(!head) return head;
    Node *ptr = head, *curr = head;
    while(curr) {
        while(ptr->next && ptr->next->data == curr->data) {
            ptr = ptr->next;
        }
        curr->next = ptr->next;
        curr = ptr->next;
        ptr = curr;
    }
    return head;
}
