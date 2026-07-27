/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            if(q.peek()==null) break;
            int size=q.size();
            Node curr=new Node();
            for(int i=0;i<size;i++){
                curr.next=q.poll();
                curr=curr.next;
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return root;
    }
}