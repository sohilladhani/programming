/* https://www.interviewbit.com/problems/rotated-sorted-array-search/ */

/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Input : [4 5 6 7 0 1 2] and target = 4
Output : 0

*/

int search(const int* A, int n1, int target) {
    int low = 0; int high = n1 - 1;
    int mid = 0;

    while(low <= high) {
        mid = low + (high - low)/2;

        if(A[mid] == target) {
            return mid;
        } else if (A[low] <= A[mid]) { //left sorted array
            //determine if the element is in the left sorted array
            if(A[low]<=target && target<A[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } else if(A[mid] <= A[high]) { //right sorted array
            //determine if the element is in the right sorted array
            if(target > A[mid] && target <= A[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }
    return -1;
}

