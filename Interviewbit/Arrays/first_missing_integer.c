/* inspiration from http://theoryofprogramming.com/2017/12/17/first-missing-integer-unsorted-array/ */
/* Problem statement: https://www.interviewbit.com/problems/first-missing-integer/ */

int firstMissingPositive(int* A, int n1) {
    
    const int flag = n1 + 2;
    int i = 0;
    
    for (i=0; i<n1; i++) {
        if(A[i] <=0 || A[i] > n1) {
            A[i] = flag;
        }
    }
    
    for (i=0; i<n1; i++) {
        if(A[i] == flag || A[i] == -flag) {
            continue;
        }
        
        int value = abs(A[i]);
        A[value - 1] = -1 * abs(A[value-1]);
    }
    
    for(i=0; i<n1; i++) {
        if(A[i] > 0) return i + 1;
    }
        
    return n1+1;
}

