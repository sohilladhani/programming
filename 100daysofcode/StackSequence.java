/* https://binarysearch.com/problems/Stack-Sequence */

import java.util.*;

class Solution {
    public boolean solve(int[] pushes, int[] pops) {
        Stack<Integer> stack = new Stack<>();
        int i = 0; int j = 0;
        while(i < pushes.length && j < pops.length) {
            stack.push(pushes[i++]);
            while(!stack.isEmpty() && pops[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
