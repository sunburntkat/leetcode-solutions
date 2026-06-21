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
    HashMap<Integer,Integer> indices=new HashMap<>();
    int k=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        k=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            indices.put(inorder[i],i);
        }
        return recBuildTree(postorder, 0,postorder.length-1);
    }
    public TreeNode recBuildTree(int[] postorder,int start, int end){
        if(start>end) return null;
        
        int mid=indices.get(postorder[k]);
        TreeNode root=new TreeNode(postorder[k]);
        k--;
        root.right=recBuildTree(postorder,mid+1,end);
        root.left=recBuildTree(postorder,start,mid-1);
        return root;
    }
}