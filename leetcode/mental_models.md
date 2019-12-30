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
| Traverse bo the lists. For each node of the lists, check 4 conditions<br>L1=NULL,L2=NULL--> next=NULL,L1!=NULL,L2=NULL--> next=L1,L1=NULL,L2!=NULL--> next=L2, L1!=NULL,L2!=NULL--> min(L1,L2) |

