/* https://binarysearch.com/problems/Smallest-Intersecting-Element */

class Solution {
    public int solve(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return -1;
        if (matrix.length == 1) {
            if (matrix[0].length == 0)
                return -1;
            return matrix[0][0];
        }
        boolean present = false;
        int ans = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            if (find(matrix[0][j], matrix) == true) {
                present = present || true;
                ans = matrix[0][j];
                break;
            } else {
                present = present || false;
            }
        }
        return present == true ? ans : -1;
    }

    private boolean find(int ele, int[][] matrix) {
        boolean present = true;
        for (int i = 1; i < matrix.length; i++) {
            present = present && search(ele, matrix[i]);
        }
        return present;
    }

    private boolean search(int ele, int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (high + low) >> 1;
            if (arr[mid] == ele)
                return true;
            else if (arr[mid] > ele)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}
