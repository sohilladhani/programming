/* Question at https://www.hackerrank.com/challenges/reverse-a-linked-list */

Node* Reverse(Node *head)
{
    if(!head || !head->next) return head;
    Node *prev = NULL;
    Node *next = NULL;
    while(head) {
        next = head->next;
        head->next = prev;
        prev = head;
        head = next;
    }
    head = prev;
    return head;
}
