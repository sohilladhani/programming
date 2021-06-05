/* https://binarysearch.com/problems/Steady-Speed */

class Solution {
    public int solve(int[] positions) {
        if (positions.length < 3)
            return 2;
        int i = 0;
        int j = 1;
        int maxWindow = Integer.MIN_VALUE;
        int diff = Math.abs(positions[j] - positions[j - 1]);
        int window = 2;
        j++;
        while (i < positions.length && j < positions.length) {
            if (diff != Math.abs(positions[j] - positions[j - 1])) {
                diff = Math.abs(positions[j] - positions[j - 1]);
                window = 2;
                i = j;
            } else {
                window++;
            }
            maxWindow = Math.max(maxWindow, window);
            j++;
        }
        return maxWindow;
    }
}
