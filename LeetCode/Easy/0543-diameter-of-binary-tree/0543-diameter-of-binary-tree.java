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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        recDepthOfBinaryTree(root);
        return max;
    }
    public int recDepthOfBinaryTree(TreeNode root){
        if(root==null) return -1;
        int leftDepth=recDepthOfBinaryTree(root.left);
        int rightDepth=recDepthOfBinaryTree(root.right);

        if(leftDepth+rightDepth+2>max){
            max=leftDepth+rightDepth+2;
        }
        return Math.max(leftDepth,rightDepth)+1;
    }
}