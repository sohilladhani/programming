/* Question at https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail */

int GetNode(Node *head,int positionFromTail)
{
    Node *tail = head;
    int posFromHead = 0;
    //reach end of the list
    while(tail->next) {
        tail = tail->next;
        posFromHead++;
    }
    int pos = posFromHead-positionFromTail;
    while(pos) {
        head = head->next;
        pos--;
    }
    return head->data;
}
