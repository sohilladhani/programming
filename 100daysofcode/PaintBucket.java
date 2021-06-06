/* https://binarysearch.com/problems/Paint-Bucket */

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public String[][] solve(String[][] matrix, int r, int c, String target) {
        String src = matrix[r][c];
        dfs(matrix, r, c, src, target);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == "x")
                    matrix[i][j] = target;
            }
        }
        return matrix;
    }

    private void dfs(String[][] matrix, int r, int c, String src, String target) {
        if (matrix[r][c] == "x")
            return;
        matrix[r][c] = "x";
        for (int k = 0; k < dx.length; k++) {
            if (isValid(matrix, src, r + dy[k], c + dx[k]) == true) {
                dfs(matrix, r + dy[k], c + dx[k], src, target);
            }
        }
    }

    private boolean isValid(String[][] matrix, String src, int r, int c) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length
            || matrix[r][c].equals("x"))
            return false;
        if (matrix[r][c].equals(src))
            return true;
        else
            return false;
    }
}
