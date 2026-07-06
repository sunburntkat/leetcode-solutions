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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        ListNode p1=head;
        for(int i=0;i<k;i++){
            if(p1.next==null){
                p1=head;
            }
            else{
                p1=p1.next;
            }
        }
        if(p1==head) return head;
        ListNode p2=head;
        while(p1.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        ListNode result=p2.next;
        p2.next=null;
        p1.next=head;
        return result;
    }
}