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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxHeightSum(root);
        return maxSum;
    }

    public Integer getMaxHeightSum(TreeNode root){
        if(root==null) return null;
        Integer leftMax=getMaxHeightSum(root.left);
        Integer rightMax=getMaxHeightSum(root.right);
        
        int maxHeightSum= Math.max(leftMax==null?Integer.MIN_VALUE:leftMax,rightMax==null?Integer.MIN_VALUE:rightMax);
        if(maxHeightSum<0){
            maxSum=Math.max(maxSum,root.val);
            return root.val;
        }
        else{
        if((leftMax==null?0:leftMax)+(rightMax==null?0:rightMax)+root.val>maxSum){
            maxSum=(leftMax==null?0:leftMax)+(rightMax==null?0:rightMax)+root.val;
        }
        if((leftMax==null?0:leftMax)+root.val>maxSum){
            maxSum=(leftMax==null?0:leftMax)+root.val;
        }
        if((rightMax==null?0:rightMax)+root.val>maxSum){
            maxSum=(rightMax==null?0:rightMax)+root.val;
        }
            return root.val+maxHeightSum;
        }
    }
}