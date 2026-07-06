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
        int length=1;
        while(p1.next!=null){
            length++;
            p1=p1.next;
        }
        k%=length;
        if(k==0) return head;
        ListNode p2=head;
        int K=length-k;
        for(int i=1;i<K;i++){
            p2=p2.next;
        }
        ListNode result=p2.next;
        p2.next=null;
        p1.next=head;
        return result;
    }
}