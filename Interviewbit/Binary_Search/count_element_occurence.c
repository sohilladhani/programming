/* https://www.interviewbit.com/problems/count-element-occurence/ */

int findCnt (const int* A, int n1, int B, int findFirst) {
    int low = 0; int high = n1-1; int result = -1;
    int mid;
    while(low <= high) {
        mid = (low + high)/2;
        if(A[mid] == B) {
            result = mid;
            if(findFirst == 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } else if (A[mid] > B) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return result;
}
 
 
int findCount(const int* A, int n1, int B) { 
    if(findCnt (A, n1, B, 1) == -1) {
        return 0;
    } else {
        return findCnt(A, n1, B, 0) - findCnt(A, n1, B, 1) + 1;
    }
}
