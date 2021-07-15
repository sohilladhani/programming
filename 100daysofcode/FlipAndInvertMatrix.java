/* https://binarysearch.com/problems/Flip-and-Invert-Matrix */

class Solution {
    public int[][] solve(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            reverseRow(matrix[i]);
            invertRow(matrix[i]);
        }
        return matrix;
    }

    private void reverseRow(int[] row) {
        for (int i = 0; i < row.length / 2; i++) {
            int temp = row[i];
            row[i] = row[row.length - i - 1];
            row[row.length - i - 1] = temp;
        }
    }

    private void invertRow(int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] = 1 - row[i];
        }
    }
}
