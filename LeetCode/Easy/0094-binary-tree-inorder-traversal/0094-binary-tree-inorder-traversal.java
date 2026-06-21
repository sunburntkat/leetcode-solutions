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
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode predecessor = curr.left;
                boolean traversed=false;
                while (predecessor.right != null) {
                    if (predecessor.right == curr) {
                        result.add(curr.val);
                        predecessor.right = null;
                        curr = curr.right;
                        traversed=true;
                        break;
                    } else {
                        predecessor = predecessor.right;
                    }
                }
                if(traversed) continue;
                predecessor.right = curr;
                curr = curr.left;
            }
        }
        return result;
    }
}