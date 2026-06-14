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
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        recForward(stack);
        return result;
    }

    public void recForward(Stack<TreeNode> prevStack){
        if(prevStack.isEmpty()){
            return;
        }
        
        List<Integer> levelInt=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while(!prevStack.isEmpty()){
            TreeNode node=prevStack.pop();
            if(node==null) continue;
            levelInt.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        if(levelInt.isEmpty()){
            return;
        }
        result.add(levelInt);
        recReverse(stack);
    }
    public void recReverse(Stack<TreeNode> prevStack){
        if(prevStack.isEmpty()){
            return;
        }
        
        List<Integer> levelInt=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while(!prevStack.isEmpty()){
            TreeNode node=prevStack.pop();
            if(node==null) continue;
            levelInt.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        if(levelInt.isEmpty()){
            return;
        }
        result.add(levelInt);
        recForward(stack);

    }
}