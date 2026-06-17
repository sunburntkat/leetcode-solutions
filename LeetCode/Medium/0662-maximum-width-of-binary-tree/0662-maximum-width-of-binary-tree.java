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
record NodePoint(TreeNode node, int x) {
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        List<NodePoint> level = new ArrayList<>();
        int maxWidth = 1;
        level.add(new NodePoint(root, 1));
        while (!level.isEmpty()) {
            List<NodePoint> newLevel = new ArrayList<>();
            for (int i = 0; i < level.size(); i++) {
                NodePoint nodePoint = level.get(i);
                if (nodePoint.node().left != null) {
                    newLevel.add(new NodePoint(nodePoint.node().left, nodePoint.x() * 2 - 1));
                }
                if (nodePoint.node().right != null) {
                    newLevel.add(new NodePoint(nodePoint.node().right, nodePoint.x() * 2));
                }
            }
            int l = 0;
            int r = newLevel.size() - 1;
            
            if (l <= r) {
                int width = newLevel.get(r).x() - newLevel.get(l).x() + 1;
                if (width > maxWidth) {
                    maxWidth = width;
                }
            }
            level = newLevel;
        }
        return maxWidth;
    }
}