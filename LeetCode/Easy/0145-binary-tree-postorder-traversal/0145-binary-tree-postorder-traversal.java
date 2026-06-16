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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        TreeNode prev = null;
        // stack.push(root);
        TreeNode curr = root;
        while (curr!=null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            System.out.println(curr != null ? curr.val : "null");
            if (curr.right == null || curr.right == prev) {
                result.add(curr.val);
                stack.pop();
                prev = curr;
                curr = null;
            } else {
                curr = curr.right;
            }

        }
        return result;
    }
}