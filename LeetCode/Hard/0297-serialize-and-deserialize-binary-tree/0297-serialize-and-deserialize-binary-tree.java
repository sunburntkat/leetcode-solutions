/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> level = new LinkedList<>();
        if (root == null)
            return "[]";
        StringBuilder sb = new StringBuilder("[");
        level.add(root);
        while (!level.isEmpty()) {
            int levelSize = level.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = level.poll();
                if (node == null) {
                    sb.append(",N");
                    continue;
                }
                sb.append("," + node.val);
                level.offer(node.left);
                level.offer(node.right);
            }
        }
        sb.deleteCharAt(1);
        sb.append("]");
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        int k = 0;
        Queue<TreeNode> level = new LinkedList<>();
        if (nodes[k] == "") return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[k]));
        k++;
        level.offer(root);
        while (!level.isEmpty()) {
            int levelSize = level.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = level.poll();
                if (!nodes[k].equals("N")) {
                    node.left = new TreeNode(Integer.parseInt(nodes[k]));
                    level.offer(node.left);
                }
                k++;
                if (!nodes[k].equals("N")) {
                    node.right = new TreeNode(Integer.parseInt(nodes[k]));
                    level.offer(node.right);
                }
                k++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));