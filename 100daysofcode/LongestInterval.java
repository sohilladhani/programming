/* https://binarysearch.com/problems/Longest-Interval */

import java.util.*;

class Solution {
    public int solve(int[][] intervals) {
        int ans = Integer.MIN_VALUE;
         if (intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> mergedIntervals = new ArrayList<>();
        int start = 0;
        int end = 1;
        int[] currentInterval = intervals[0];
        mergedIntervals.add(currentInterval);
        for (int[] nextInterval : intervals) {
            // don't overlap
            if (currentInterval[end] < nextInterval[start]) {
                mergedIntervals.add(nextInterval);
                currentInterval = nextInterval;
            } else {
                currentInterval[end] = Math.max(currentInterval[end], nextInterval[end]);
            }
        }
        for (int[] interval : mergedIntervals) {
            ans = Math.max(ans, interval[end] - interval[start] + 1);
        }
        return ans;
    }
}
