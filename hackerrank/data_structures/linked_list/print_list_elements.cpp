/* Question link: https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list */

void Print(Node *head)
{
    while (head) {
        cout<<head->data<<endl;
        head = head->next;
    }
}
