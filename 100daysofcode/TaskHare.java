/* https://binarysearch.com/problems/Task-Hare */

import java.util.*;

class Solution {
    public int solve(int[] tasks, int[] people) {
        Arrays.sort(tasks);
        Arrays.sort(people);
        int ans = 0;
        int i = tasks.length - 1;
        int j = people.length - 1;

        while (i >= 0 && j >= 0) {
            if (tasks[i] <= people[j]) {
                ans++;
                i--;
                j--;
            } else {
                i--;
            }
        }
        return ans;
    }
}
