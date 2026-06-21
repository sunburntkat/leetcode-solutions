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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result =new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null){
            result.add(curr.val);
            if(curr.left==null){
                curr=curr.right;
            }
            else{
                TreeNode predecessor=curr.left;
                boolean traversed=false;
                while(predecessor.right!=null){
                    if(predecessor.right==curr){
                        predecessor.right=null;
                        traversed=true;
                        break;
                    }
                    predecessor=predecessor.right;
                }
                if(traversed) continue;
                predecessor.right=curr.right;
                curr=curr.left;
            }
        }   
        return result;
    }
}