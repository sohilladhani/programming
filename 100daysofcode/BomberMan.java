import java.util.*;

class Solution {
    public int solve(int[][] matrix) {
        int ans = 0;
        int n = matrix.length; int m = matrix[0].length;
        boolean[] row_bombs = new boolean[n];
        boolean[] col_bombs = new boolean[m];
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 1) {
                    row_bombs[i] = true;
                    col_bombs[j] = true;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(row_bombs[i] == true || col_bombs[j] == true) {
                    matrix[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) ans++;
            }
        }
        return ans;
    }    
}
