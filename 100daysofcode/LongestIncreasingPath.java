/* https://binarysearch.com/problems/Longest-Increasing-Path */

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solve(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int longestPath = Integer.MIN_VALUE;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                longestPath = Math.max(longestPath, dfs(matrix, i, j, cache));
            }
        }
        return longestPath;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] > 0)
            return cache[i][j];
        int max = 0;
        for (int k = 0; k < dx.length; k++) {
            if (isValid(matrix, i, j, i + dy[k], j + dx[k]) == true) {
                max = Math.max(dfs(matrix, i + dy[k], j + dx[k], cache), max);
            }
        }
        return cache[i][j] = 1 + max;
    }

    private boolean isValid(int[][] matrix, int i, int j, int m, int n) {
        if (m < 0 || m >= matrix.length || n < 0 || n >= matrix[m].length)
            return false;
        if (matrix[m][n] > matrix[i][j])
            return true;
        return false;
    }
}
