/* https://binarysearch.com/problems/Characters-in-Each-Bracket-Depth */

import java.util.*;

class Solution {
    public int[] solve(String s) {
        Stack<Character> stack = new Stack<>();
        int depth = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                depth++;
                map.put(depth, map.getOrDefault(depth, 0));
            } else if(s.charAt(i) == 'X') {
                stack.push(s.charAt(i));
                map.put(depth, new Integer(map.getOrDefault(depth, 0) + 1));
            } else {
                while(!stack.isEmpty()) {
                    if(stack.pop() == '(') {
                        depth--;
                        break;
                    }
                }
            }
        }
        int[] ans = new int[map.size()];
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getKey() != -1) ans[entry.getKey()] = entry.getValue();
        }
        return ans;
    }
}
