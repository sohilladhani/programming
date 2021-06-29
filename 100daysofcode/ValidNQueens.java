/* https://binarysearch.com/problems/Valid-N-Queens */

class Solution {
    public boolean solve(int[][] matrix) {
        int noOfQueens = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    noOfQueens++;
                    if (isValid(matrix, i, j) == false)
                        return false;
                }
            }
        }
        if (noOfQueens < matrix.length)
            return false;
        return true;
    }

    private boolean isValid(int[][] matrix, int i, int j) {
        // col sum
        int sum = 0;
        for (int k = 0; k < matrix[i].length; k++) {
            sum += matrix[i][k];
        }
        if (sum > 1)
            return false;

        // row sum
        sum = 0;
        for (int k = 0; k < matrix.length; k++) {
            sum += matrix[k][j];
        }
        if (sum > 1)
            return false;

        // diagonal sum
        sum = 0;
        int m = i - 1;
        int n = j - 1;
        while (m >= 0 && n >= 0) {
            sum += matrix[m][n];
            m--;
            n--;
        }
        m = i + 1;
        n = j + 1;
        while (m < matrix.length && n < matrix[m].length) {
            sum += matrix[m][n];
            m++;
            n++;
        }
        if (sum > 1)
            return false;

        sum = 0;
        m = i - 1;
        n = j + 1;
        while (m >= 0 && n < matrix[m].length) {
            sum += matrix[m][n];
            m--;
            n++;
        }
        if (sum > 1)
            return false;

        m = i + 1;
        n = j - 1;
        while (m < matrix.length && n >= 0) {
            sum += matrix[m][n];
            m++;
            n--;
        }
        sum += matrix[i][j];
        if (sum > 1)
            return false;
        return true;
    }
}
