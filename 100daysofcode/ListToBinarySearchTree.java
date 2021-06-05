/* https://binarysearch.com/problems/List-to-Binary-Search-Tree */

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public Tree solve(int[] nums) {
        return createBST(nums, 0, nums.length);
    }

    private Tree createBST(int[] nums, int low, int high) {
        if (low >= high)
            return null;
        Tree root = new Tree();
        int mid = low + (high - low) / 2;
        root.val = nums[mid];
        root.left = createBST(nums, low, mid);
        root.right = createBST(nums, mid + 1, high);
        return root;
    }
}
