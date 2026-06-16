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
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        if(root==null) return true;
        leftStack.push(root.left);
        rightStack.push(root.right);
        while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
            if (leftStack.size() != rightStack.size()) {
                return false;
            }
            Stack<TreeNode> newLeftStack = new Stack<>();
            Stack<TreeNode> newRightStack = new Stack<>();
            while (!leftStack.isEmpty()) {
                TreeNode leftNode=leftStack.pop();
                TreeNode rightNode=rightStack.pop();
                if(leftNode==null && rightNode==null){
                    continue;
                }
                if(leftNode==null || rightNode==null){
                    return false;
                }
                if(leftNode.val!=rightNode.val){
                    return false;
                }
                newLeftStack.push(leftNode.left);
                newLeftStack.push(leftNode.right);
                newRightStack.push(rightNode.right);
                newRightStack.push(rightNode.left);
            }
            leftStack=newLeftStack;
            rightStack=newRightStack;
        }
        return true;
    }
}