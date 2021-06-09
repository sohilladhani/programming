/* https://binarysearch.com/problems/Level-Order-Alternating */

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public int[] solve(Tree root) {
        if(root == null) return new int[0];
        Stack<Tree> s1 = new Stack<>();
        Stack<Tree> s2 = new Stack<>();
        List<Integer> list = new ArrayList<>();

        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()) {
            while(!s1.isEmpty()) {
                Tree node = s1.pop();
                list.add(node.val);
                if(node.left != null) s2.push(node.left);
                if(node.right != null) s2.push(node.right);
            }
            while(!s2.isEmpty()) {
                Tree node = s2.pop();
                list.add(node.val);
                if(node.right != null) s1.push(node.right);
                if(node.left != null) s1.push(node.left);
            }
        }
        int[] ans = new int[list.size()];
        int idx = 0;
        for(int ele: list) {
            ans[idx++] = ele;
        }
        return ans;
    }
}
