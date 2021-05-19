import java.util.*;

class Solution {
    public boolean solve(String s) {
        Stack<Character> st = new Stack<>();
        boolean ans = false;

        for(char c: s.toCharArray()) {
            if(c == '(') {
                st.push(c);
            } else if(c == ')') {
                if(!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(c);
                }
            }
        }
        if(st.isEmpty()) ans = true;
        return ans;
    }
}
