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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result=new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr=stack.pop();
            if (curr==null) continue;
            if(curr.left==null){
                result.add(curr.val);
                stack.push(curr.right);
            }else{
                stack.push(curr);
                stack.push(curr.left);
                curr.left=null;
            }
        }
        return result;
    }
}