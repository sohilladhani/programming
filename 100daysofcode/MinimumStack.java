/* https://binarysearch.com/problems/Minimum-Stack */

import java.util.*;

class MinimumStack {
    Stack<Integer> stack = null;
    Stack<Integer> minStack = null;

    public MinimumStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void append(int val) {
        stack.push(val);
        if(!minStack.isEmpty()) {
            minStack.push(Math.min(minStack.peek(), val));
        } else {
            minStack.push(val);
        }
        
    }

    public int peek() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }
}
