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
    Stack<TreeNode> stack=new Stack<>();
    HashMap<Integer,Integer> indices=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            indices.put(inorder[i],i);
        }
        TreeNode tree=new TreeNode(preorder[0]);
        stack.push(tree);
        for(int i=1;i<preorder.length;i++){
            TreeNode parent=stack.peek();
            if(indices.get(preorder[i])<indices.get(parent.val)){
                TreeNode newLeftNode=new TreeNode(preorder[i]);
                parent.left=newLeftNode;
                stack.push(newLeftNode);
            }
            else{
                while(!stack.isEmpty() && indices.get(preorder[i])>indices.get(stack.peek().val)){
                    parent=stack.pop();
                }
                TreeNode newRightNode=new TreeNode(preorder[i]);
                parent.right=newRightNode;
                stack.push(newRightNode);
            }
        }
        return tree;
    }
}