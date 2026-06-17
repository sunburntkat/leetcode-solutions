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
    public List<TreeNode> list =new ArrayList<>();
    HashSet<Integer> resultSet=new HashSet<>();
    HashSet<TreeNode> visited=new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        DFS(root,target);
        int length=Math.min(k+1,list.size());
        recDistanceK(target,k);
        visited.add(target);

        for(int i=0;i<length;i++){
            System.out.println(list.get(i).val);
            recDistanceK(list.get(i),k-i-1);
            visited.add(list.get(i));
        
        }
        return new ArrayList<>(resultSet);
    }
    public boolean DFS(TreeNode node, TreeNode target){
        if(node==target){
            // list.add(node);
            return true;
        }
        boolean found=false;
        if(node.left!=null){
            found=DFS(node.left,target);
        }
        if(!found && node.right!=null){
            found=DFS(node.right,target);
        }
        if(found){
            list.add(node);
        }
        return found;
    }
    public void recDistanceK(TreeNode root, int k){
        if(root==null) return;
        if(visited.contains(root)){
            return;
        }
        if(k==0) {
            resultSet.add(root.val);
            return;
        }
        recDistanceK(root.left, k-1);
        recDistanceK(root.right, k-1);

    }
}