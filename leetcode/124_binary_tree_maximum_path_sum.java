/* 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting 
node to any node in the tree along the parent-child connections. The path must 
contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6

Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42

*/

class BinaryTreeMaxPathSum {
    int mps; 
    public int maxPathSum(TreeNode root) {
        mps = Integer.MIN_VALUE;
        mpsHelper(root);
        return mps;
    }
    
    private int mpsHelper(TreeNode root) {
        //Explanation: https://www.youtube.com/watch?v=_wUz0XKQ5JM
        if(root == null) return 0;
        int leftMax = Math.max(0, mpsHelper(root.left));
        int rightMax = Math.max(0, mpsHelper(root.right));
        // remove this line if the question was to include root node compulsarily
        // mps maintains maximum by traversing every node.
        mps = Math.max(mps, root.val + leftMax + rightMax); 
        
        return Math.max(leftMax, rightMax) + root.val;
    }
}
