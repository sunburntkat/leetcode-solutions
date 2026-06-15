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
record Position(TreeNode node, int y, int x) {
}

class Solution {
    List<Integer>[] resultArr = new ArrayList[2000];
    List<Position> level = new ArrayList<Position>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        level.add(new Position(root, 0, 0));
        int[][] lastRowPerColumn = new int[2000][];
        while (!level.isEmpty()) {
            List<Position> newLevel = new ArrayList<Position>();
            for (int i = 0; i < level.size(); i++) {
                Position nodePosition = level.get(i);
                if (nodePosition.node() == null)
                    continue;
                if (resultArr[nodePosition.x() + 1000] == null) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nodePosition.node().val);
                    resultArr[nodePosition.x() + 1000] = list;
                } else {
                    List<Integer> resultSpot = resultArr[nodePosition.x() + 1000];
                    int index = resultSpot.size() - 1;
                    int start=index-(lastRowPerColumn[nodePosition.x() + 1000][1]);
                    while (index > start && lastRowPerColumn[nodePosition.x() + 1000][0] == nodePosition.y()
                            && resultSpot.get(index) > nodePosition.node().val) {
                        index--;
                    }
                    resultSpot.add(index + 1, nodePosition.node().val);

                }
                if(lastRowPerColumn[nodePosition.x() + 1000]== null){
                    lastRowPerColumn[nodePosition.x() + 1000] = new int[2];
                }
                if (lastRowPerColumn[nodePosition.x() + 1000][0] == nodePosition.y()) {
                    lastRowPerColumn[nodePosition.x() + 1000][1]++;
                } else {
                    lastRowPerColumn[nodePosition.x() + 1000][0] = nodePosition.y();
                    lastRowPerColumn[nodePosition.x() + 1000][1] = 1;
                }
                newLevel.add(new Position(nodePosition.node().left, nodePosition.y() + 1, nodePosition.x() - 1));
                newLevel.add(new Position(nodePosition.node().right, nodePosition.y() + 1, nodePosition.x() + 1));
            }
            level = newLevel;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < resultArr.length; i++) {
            if (resultArr[i] == null)
                continue;
            result.add(resultArr[i]);
        }
        return result;
    }

}