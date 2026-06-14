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
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> prevStack = new Stack<>();
        prevStack.push(root);
        int i=0;
        while (!prevStack.isEmpty()) {
            List<Integer> levelInt = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (!prevStack.isEmpty()) {
                TreeNode node = prevStack.pop();
                if (node == null)
                    continue;
                levelInt.add(node.val);
                stack.push(i%2==0?node.left:node.right);
                stack.push(i%2==0?node.right:node.left);
            }
            if (levelInt.isEmpty()) {
                continue;
            }
            result.add(levelInt);
            prevStack=stack;
            i++;
            
        }
        return result;
    }
}