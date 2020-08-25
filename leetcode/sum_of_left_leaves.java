/* Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively.
Return 24.
*/

/*
 * Definition for a binary tree node.
 */
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
class SumOfLeftLeaves {
    int sum = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    public int sumOfLeftLeaves(TreeNode root) {
        /* a node is left leave if node == leaf && node = node.parent.left */
        TreeNode temp = root;
        traverse(temp, queue);
        while(!queue.isEmpty()) {
            if(queue.peek() == null) {
                queue.poll();
                sum += queue.poll().val;
            } else {
                queue.poll();
            }
        }
        return sum;
    }
    
    private void traverse(TreeNode root, Queue q) {
        if(root == null) return;
        q.add(root);
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) {
                q.add(null);
            }
            traverse(root.left, q);
        }
        if(root.right != null) {
            traverse(root.right, q);
        }
    }
}
