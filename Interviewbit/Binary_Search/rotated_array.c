/* https://www.interviewbit.com/problems/rotated-array/ */

/* Suppose a sorted array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array will not contain duplicates.

NOTE 1: Also think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*

PROBLEM APPROACH:

Note: If you know the number of times the array is rotated, then this problem becomes trivial. If the number of rotation is x, then minimum element is A[x].
Lets look at how we can calculate the number of times the array is rotated.

Complete solution in the hints.  */

int findMin(const int* A, int n1) {
    int low = 0; int high = n1-1; int mid = -1;
    int prev = -1; int next = -1;
    while(low <= high) {
        //Case 1: array already sorted.
        //Element at the 0th index is the minimum
        if(A[low] <= A[high]) {
            return A[low];
        }
        mid = low + (high - low)/2;
        //Case 2: Pivot property: if element in the left
        //and the element in the right are greater than
        //current element, the current element is the pivot.
        //return the current element.
        prev = (mid - 1 + n1) % n1;
        next = (mid + 1) % n1;
        if(A[mid] <= A[prev] && A[mid] <= A[next]) {
            return A[mid];
        } else if (A[mid] <= A[high]) {
            //Case 3: Elements to the right are already sorted
            //Look at the left portion
            high = mid - 1;
        } else if (A[mid] >= A[low]) {
            //Case 4: Elements to the left are already sorted
            //Look at the right portion
            low = mid + 1;
        }
    }

    return -1;
}
