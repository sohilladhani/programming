/* https://binarysearch.com/problems/Tree-Traversal */

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public int solve(Tree root, String[] moves) {
        Stack<Tree> stack = new Stack<>();
        stack.push(root);
        for (String move : moves) {
            switch (move) {
                case "RIGHT":
                    stack.push(stack.peek().right);
                    break;
                case "LEFT":
                    stack.push(stack.peek().left);
                    break;
                case "UP":
                    stack.pop();
                    break;
                default:
                    break;
            }
        }
        return stack.peek().val;
    }
}
