/* https://binarysearch.com/problems/Largest-Island-Area */

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int ans = 0;
    int maxArea = Integer.MIN_VALUE;
    public int solve(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1) {
                    ans = 0;
                    dfs(matrix, i, j);
                    maxArea = Math.max(ans, maxArea);
                }
            }
        }
        return maxArea == Integer.MIN_VALUE? 0: maxArea;
    }

    private void dfs(int[][] matrix, int i, int j) {
        if(matrix[i][j] == -1) return;
        matrix[i][j] = -1;
        ans++;
        for(int k = 0; k < dx.length; k++){
            if(isValid(matrix, i + dy[k], j + dx[k]) == true) {
                dfs(matrix, i + dy[k], j + dx[k]);
            }
        }
    }

    private boolean isValid(int[][] matrix, int i, int j) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 0) return false;
        return true; 
    }

}
