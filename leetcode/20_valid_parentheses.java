/* 20. Valid Parentheses - https://leetcode.com/problems/valid-parentheses */
/* Given a string containing just the characters '(', ')', '{', '}', '[' and ']'
   determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true

Example 2:

Input: "()[]{}"
Output: true

Example 3:

Input: "(]"
Output: false

Example 4:

Input: "([)]"
Output: false

Example 5:

Input: "{[]}"
Output: true

*/
import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> parentheses = new Stack<>();
        int sLength = s.length();
        if (sLength == 0) return true;
        for (int i = 0; i < sLength; i++) {
            char par = s.charAt(i);
            switch (par) {
                case ')':
                    if (!parentheses.isEmpty() && parentheses.peek() == '(') {
                        parentheses.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (!parentheses.isEmpty() && parentheses.peek() == '{') {
                        parentheses.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (!parentheses.isEmpty() && parentheses.peek() == '[') {
                        parentheses.pop();
                    } else {
                        return false;
                    }
                    break;
                default:
                    parentheses.push(par);
                    break;
            }
        }
        if (parentheses.isEmpty() ) {
            return true;
        }
        return false;        
    }

    public static void main (String args[]) {
        ValidParentheses vp = new ValidParentheses();
        String s = "()";
        System.out.println(vp.isValid(s));
        s = "()[]{}";
        System.out.println(vp.isValid(s));
        s = "(]";
        System.out.println(vp.isValid(s));
        s = "([)]";
        System.out.println(vp.isValid(s));
        s = "{[]}";
        System.out.println(vp.isValid(s));
        s = "]";
        System.out.println(vp.isValid(s));
        s = "}";
        System.out.println(vp.isValid(s));
        s = ")";
        System.out.println(vp.isValid(s));
        s = "";
        System.out.println(vp.isValid(s));
    }
}
