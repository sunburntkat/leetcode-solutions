/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxHeightSum(root);
        return maxSum;
    }

    public int getMaxHeightSum(TreeNode root) {
        if (root == null)
            return 0;
        int leftMax = Math.max(0, getMaxHeightSum(root.left));
        int rightMax = Math.max(0, getMaxHeightSum(root.right));

        int maxHeightSum = Math.max(leftMax, rightMax);

        if (leftMax + rightMax + root.val > maxSum) {
            maxSum = leftMax + rightMax + root.val;
        }
        return root.val + maxHeightSum;
    }
}