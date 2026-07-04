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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode();
        result.next = head;
        ListNode prevGroupTail = result;
        ListNode groupHead = prevGroupTail.next;
        outer:
        while (groupHead != null) {
            int c = k;
            ListNode curr = groupHead;
            ListNode prev = null;
            for(int i=0;i<k-1;i++){
                if(curr.next==null){
                    prevGroupTail.next =groupHead;
                    break outer;
                }
                curr=curr.next;
            }
            curr=groupHead;
            while (c > 0 && curr != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
                c--;
            }
            prevGroupTail.next = prev;
            prevGroupTail = groupHead;
            groupHead=curr;
        }
        return result.next;
    }
}