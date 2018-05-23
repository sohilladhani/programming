/* Question at https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle */

bool has_cycle(Node* head) {
    bool loop = false;
    if(head) {
        Node *fast = head; Node *slow = head;
        while(1) {
            if(fast->next->next) {
                fast = fast->next->next;
                slow = slow->next;
            } else {
                break;
            }
            if(fast == slow) {
                loop = true;
                break;
            }
        }
    }
    return loop;
}
