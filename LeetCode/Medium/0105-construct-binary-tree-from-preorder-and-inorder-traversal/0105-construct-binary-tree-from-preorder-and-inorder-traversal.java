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
    int k=0;
    HashMap<Integer,Integer> indices=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            indices.put(inorder[i],i);
        }
        return recBuildTree(preorder, 0, preorder.length-1);
    }
    public TreeNode recBuildTree(int[] preorder, int start, int end){
        if(start>end) return null;
        
        TreeNode root=new TreeNode(preorder[k]);
        int mid=indices.get(preorder[k]);
        k++;
        root.left=recBuildTree(preorder,start,mid-1);
        root.right=recBuildTree(preorder,mid+1,end);
        return root;
    }
}