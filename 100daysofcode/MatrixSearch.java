/* https://binarysearch.com/problems/Matrix-Search */

import java.util.*;

class Solution {
    public int solve(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                maxHeap.offer(matrix[i][j]);
                if(maxHeap.size() > k+1) maxHeap.remove();
            }
        }
        return maxHeap.remove();
    }
}
