## Mental Models for the problems

Inspired by this post: [Link](https://hackernoon.com/what-it-took-to-land-my-dream-software-engineering-job-17c01240266b)

### Difficulty: Easy

#### [1290 Convert Binary To Integer](https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer) 
#### [Solution](1290_convert_binary_to_integer.java)

|                      Description                              |
| :-----------------------------------------------------------: |
| Convert binary number in Linked List to corresponding integer |

| Mental Model                                                                 |
| :--------------------------------------------------------------------------: |
| For each node multiply current decimal value by 2 and add current node value |

| Tricks                                                                   |
| :----------------------------------------------------------------------: |
| Use Left shift (<<1) for multiplication and Bitwise OR (\|) for addition |

---

#### [13 Roman to Integer](https://leetcode.com/problems/roman-to-integer)
#### [Solution](13_roman_to_integer.java)

|                      Description                              |
| :-----------------------------------------------------------: |
| Convert Roman numerals to the corresponding integer           |

| Mental Model                                                                 |
| :--------------------------------------------------------------------------: |
| For every roman numeral add the its value to current integer                 |

| Tricks                                                                                                                    |
| :-----------------------------------------------------------------------------------------------------------------------: |
| I before V and X --> add 3 and 8, X before L and C --> 30 and 80, C before D and M --> 300 and 800 to current integer value  |

---

#### [21 Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists)
#### [Solution](21_merge_two_sorted_lists.java)

|                      Description                              |
| :-----------------------------------------------------------: |
| Merge two sorted linked lists and return as new list          |

| Mental Model                                                                 |
| :--------------------------------------------------------------------------: |
| Iteration: Create a dummy node. Traverse bo the lists. For each node of the lists, check 4 conditions<br>L1=NULL,L2=NULL--> next=NULL,L1!=NULL,L2=NULL--> next=L1,L1=NULL,L2!=NULL--> next=L2, L1!=NULL,L2!=NULL--> min(L1,L2) |

---

#### [242 Valid Anagram](https://leetcode.com/problems/valid-anagram)
#### [Solution](242_valid_anagram.java)

|                      Description                              |
| :-----------------------------------------------------------: |
| Determine if 2 strings are anagram of each other              |

| Mental Model                                                                 |
| :--------------------------------------------------------------------------: |
| ASCII: Create an array of size 128 (all 0's). For each character of s1, increment corresponding ascii index. For s2, decrement corresponding ascii index. If all elements the array are 0's return true, else false |

---

#### [141 Linked List Cycle](https://leetcode.com/problems/linked-list-cycle)
#### [Solution](141_linked_list_cycle.java)

|                      Description                              |
| :-----------------------------------------------------------: |
| Determine if there is a cycle in the linked list              |

| Mental Model                                                                 |
| :--------------------------------------------------------------------------: |
| Create 2 pointers: fast and slow. Move fast by 2 steps and slow by 1 step. If both meet, cycle is present |

---

#### [155 Min Stack](https://leetcode.com/problems/min-stack)
#### [Solution](155_min_stack.java)

|                      Description                              |
| :-----------------------------------------------------------: |
| Design a stack which has a method getMin() to return the min element in O(1) time |

| Mental Model                                                                 |
| :--------------------------------------------------------------------------: |
| Create a 'min stack' which tracks the minimum elements such that the top always returns the minimum value. Make getMin() return that value | 

