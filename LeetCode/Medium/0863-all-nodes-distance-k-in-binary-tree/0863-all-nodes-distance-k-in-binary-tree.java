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
    HashMap<TreeNode, TreeNode> parents = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashSet<TreeNode> visited = new HashSet<>();
        parents.put(root, null);
        findParents(root);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        int level = 0;
        while (!q.isEmpty()) {
            if (level == k)
                break;
            int length = q.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = q.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    q.offer(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    q.offer(node.right);
                }
                if (node != root && !visited.contains(parents.get(node))) {
                    q.offer(parents.get(node));
                }
                visited.add(node);
            }
            level++;
        }
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
            TreeNode node=q.poll();
            result.add(node.val);
        }
        return result;
    }

    public void findParents(TreeNode node) {
        if (node == null)
            return;
        if (node.left != null) {
            parents.put(node.left, node);
            findParents(node.left);
        }
        if (node.right != null) {
            parents.put(node.right, node);
            findParents(node.right);
        }
    }

    // public void recDistanceK(TreeNode root, int k) {
    //     if (root == null)
    //         return;
    //     if (visited.contains(root)) {
    //         return;
    //     }
    //     if (k == 0) {
    //         resultSet.add(root.val);
    //         return;
    //     }
    //     recDistanceK(root.left, k - 1);
    //     recDistanceK(root.right, k - 1);

    // }
}