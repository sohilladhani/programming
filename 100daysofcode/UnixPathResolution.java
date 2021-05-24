/* https://binarysearch.com/problems/Unix-Path-Resolution */
import java.util.*;

class Solution {
    public String[] solve(String[] path) {
        Stack<String> stack = new Stack<>();
        String[] ans = null;
        for(int i = 0; i < path.length; i++) {
            if(path[i].equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            } else if(!path[i].equals(".")) {
                stack.push(path[i]);
            }
        }
        int idx = stack.size()-1;
        ans = new String[stack.size()];
        while(!stack.isEmpty()) {
            ans[idx--] = stack.pop();
        }
        return ans;
    }
}
