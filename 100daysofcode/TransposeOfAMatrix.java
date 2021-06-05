/* https://binarysearch.com/problems/Transpose-of-a-Matrix */

class Solution {
    public int[][] solve(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = matrix[i].length-1; j >=i; j--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }
}
