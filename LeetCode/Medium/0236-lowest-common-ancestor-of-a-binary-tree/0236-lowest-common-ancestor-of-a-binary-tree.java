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
    TreeNode parent = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recLowestCommonAncestor(root,p,q);
        return parent;
    }

    public boolean recLowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null){
            return false;
        }
        if (node == p || node == q) {
            if(parent==null) parent = node;
            return true;
        }
        boolean left = recLowestCommonAncestor(node.left, p, q);
        boolean right = recLowestCommonAncestor(node.right, p, q);
        if(left && right){
            parent=node;
        }
        return left || right;
    }
}
