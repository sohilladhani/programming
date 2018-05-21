/* Question at https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse */

Node* reverse_list(Node *head) {
    Node* prev = NULL;
    Node* next = NULL;
    while(head) {
        next = head->next;
        head->next = prev;
        prev = head;
        head = next;
    }
    head = prev;
    return head;
}
void ReversePrint(Node *head)
{
    //if head is null
    if(!head) return;
    //only 1 element
    if(!head->next) {
        cout<<head->data<<endl;
    } else {
        //reverse the list
        head = reverse_list(head);
        while(head) {
            cout<<head->data<<endl;
            head = head->next;
        }
    }
}
