/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        TreeNode parent = null;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        boolean found1=false;

        while (curr != null || !stack.isEmpty()) {
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;

            }
            curr=stack.peek();
            if(curr.right==null || curr.right==prev){
                if(curr.val==p.val || curr.val==q.val){
                    if(!found1){
                        found1=true;
                        parent=curr;
                    } 
                    else{
                        return parent;
                    }
                }
                stack.pop();
                if(curr==parent){
                    parent=stack.peek();
                }
                prev=curr;
                curr=null;
            }
            else{
                curr=curr.right;
            }
        }
        return null;

    }
}