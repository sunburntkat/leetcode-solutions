/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        ListNode result=new ListNode(-1);
        ListNode curr=result;
        for (int i=0;i<lists.length;i++){
            if(lists[i]==null) continue;
            pq.add(lists[i]);
        }
        while(!pq.isEmpty()){
            ListNode min=pq.poll();
            if(min.next!=null){
                pq.add(min.next);
            }
            curr.next=min;
            curr=curr.next;   
        }
        return result.next;
    }
}