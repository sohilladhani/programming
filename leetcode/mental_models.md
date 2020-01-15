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

---

#### [20 Valid Parentheses](https://leetcode.com/problems/valid-parentheses)
#### [Solution](20_valid_parentheses.java)

|                      Description                              |
| :-----------------------------------------------------------: |
| Given a string containing just the characters '(', ')', '{', '}', '[' and ']' determine if the input string is valid |

| Mental Model                                                                 |
| :--------------------------------------------------------------------------: |
| Create a stack. Push openning parentheses. For every closing parentheses, if the top of stack contains the corresponding open parentheses, pop the stack, else return false. At the end if stack is empty, return true | 

---

#### [88 Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array)
#### [Solution](88_merge_sorted_array.java)

|                      Description                              |
| :-----------------------------------------------------------: |
| Given two sorted integer arrays nums1 (size = m) and nums2 (size = n), merge nums2 into nums1 as one sorted array. Resultant array should be nums1. nums1 is of enough capacity |

| Mental Model                                                                 |
| :--------------------------------------------------------------------------: |
| Create 3 pointers - 1 for first array (n1), 1 for second array (n2) and 1 for the rest of elements (h). If n!=0 then... If nums1[n1] > nums2[n2], make space for nums2[n2] by shifting elements in nums1, else increment n1. Corner cases: (1) m=0, n=1 ==> nums1 = num2 |

---

#### [160 Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists)
#### [Solution](160_intersection_of_two_linked_lists.java)

|                      Description                              |
| :-----------------------------------------------------------: |
| Find the node at which the intersection of two singly linked lists begins | 

| Mental Model                                                                 |
| :--------------------------------------------------------------------------: |
| Find difference (d) of lengths of the lists. Start from 'd' steps of the longer list and from starting node of the other list. Move single step. When they meet, it's the intersecting node |

---

### Difficulty: Medium

#### [142 Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii)
#### [Solution](142_linked_list_cycle_2.java)

|                      Description                              |
| :-----------------------------------------------------------: |
| Determine if there is a cycle in the linked list and return the node where the cycle begins |

| Mental Model                                                                 |
| :--------------------------------------------------------------------------: |
| Create 2 pointers: fast and slow. Move fast by 2 steps and slow by 1 step. If both meet, cycle is present. Make fast point to head. Make fast and slow move by 1 step. The node where they meet is the beginning of the cycle. This is also calld Floyd's algo for cycle detection. Reason it works? Let (d = distance to the start of loop), (k = distance from start of the loop), (l = length of the loop), (i = no. of cycles covered in the loop by fast pointer), (j = no. of cycles covered in the loop by slow pointer), (f = distance travelled by the fast pointer), (s = dist travelled by the slow pointer). Hence, (f = d + k + l.i), (s = d + k + j.l). Both fast and slow pointer meet at the node 'k' steps away from the start of the loop. We know that (f = 2.s). So, (d + k + i.l = 2.d + 2.k + 2.j.l). So, (d + k = (i-2.j).l). (i-2j) is an integer. So, (d + k = N.l). Hence, (N.l) is the start of the loop. When we put fast pointer at the start of the list and move both the pointers only 1 step at a time, and the fast pointer travels distance = d, slow pointer has also travelled d distance, and since slow pointer was already at the node 'k' steps away from the start of the loop, slow pointer is now at the node (d + k). And since (d + k = N.l = start of the loop), we can say that both the pointers met at the start of the loop and return that node. |

---

