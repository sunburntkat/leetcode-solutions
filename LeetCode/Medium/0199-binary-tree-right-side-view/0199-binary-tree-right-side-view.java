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
    public List<Integer> rightSideView(TreeNode root) {
        List<TreeNode> level = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            level.add(root);
        }
        while (!level.isEmpty()) {
            List<TreeNode> newLevel = new ArrayList<>();
            TreeNode rightNode = level.get(level.size() - 1);
            result.add(rightNode.val);
            for (int i = 0; i < level.size(); i++) {
                TreeNode node = level.get(i);
                if (node.left != null) {
                    newLevel.add(node.left);
                }
                if (node.right != null) {
                    newLevel.add(node.right);
                }
            }
            level = newLevel;
        }
        return result;
    }
}