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
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        recTraversal(root, 0);
        return result;
    }

    public void recTraversal(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(level, root.val);
        } else {
            result.set(level, root.val);
        }
        recTraversal(root.left, level + 1);
        recTraversal(root.right, level + 1);
    }
}