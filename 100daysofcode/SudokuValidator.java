/* https://binarysearch.com/problems/Sudoku-Validator */

import java.util.*;

class Solution {
    public boolean solve(int[][] matrix) {
        int N = matrix.length;
        if (isPerfectSquare(N) == false)
            return false;
        int subGridSize = (int) Math.sqrt(N);
        return validateSudoku(matrix, subGridSize);
    }

    private boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    private boolean validateSudoku(int[][] matrix, int subGridSize) {
        Set<String> seenSet = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] <= 0 || matrix[i][j] > matrix.length)
                    return false;
                else {
                    if (!seenSet.add("row" + i + matrix[i][j])
                        || !seenSet.add("column" + j + matrix[i][j])) {
                        return false;
                    }
                    if (!seenSet.add("subgrid" + (i / subGridSize) * subGridSize + j / subGridSize
                            + matrix[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
