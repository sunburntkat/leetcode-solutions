/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Integer> originalList=new HashMap<>();
        HashMap<Integer,Node> newList=new HashMap<>();
        if(head==null) return null;
        Node result=new Node(head.val);
        int i=0;
        originalList.put(head,i);
        newList.put(i++,result);
        Node currOld=head.next;
        Node currNew=result;
        while(currOld!=null){
            currNew.next=new Node(currOld.val);
            originalList.put(currOld,i);
            newList.put(i++,currNew.next);
            currNew=currNew.next;
            currOld=currOld.next;
        }

        currNew=result;
        currOld=head;
        while(currOld!=null){
            currNew.random=currOld.random==null ? null:newList.get(originalList.get(currOld.random));
            currNew=currNew.next;
            currOld=currOld.next;
        }
        return result;
    }   
}