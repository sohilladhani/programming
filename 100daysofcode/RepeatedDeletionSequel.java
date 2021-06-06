/* https://binarysearch.com/problems/Repeated-Deletion-Sequel */

import java.util.*;

class Solution {
    class Pair {
        char c;
        int freq;
        Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    public String solve(String s, int k) {
        if (k == 1)
            return "";
        Stack<Pair> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek().c == s.charAt(i)) {
                stack.peek().freq++;
            } else {
                stack.push(new Pair(s.charAt(i), 1));
            }
            if (stack.peek().freq == k) {
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            while (p.freq-- > 0) {
                sb.insert(0, p.c);
            }
        }
        return sb.toString();
    }
}
