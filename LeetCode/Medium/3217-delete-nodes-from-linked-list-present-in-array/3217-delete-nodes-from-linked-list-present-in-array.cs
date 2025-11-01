/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode ModifiedList(int[] nums, ListNode head) {
        var hashset=new HashSet<int>();
        for(int i=0;i<nums.Length;i++){
            hashset.Add(nums[i]);
        }
        var node=head;
        while(node.next!=null){
            if(hashset.Contains(node.next.val)){
                node.next=node.next.next;
            }
            else{
                node=node.next;
            }
        }
        if(!hashset.Add(head.val)){
            head=head.next;
        }
        return head;
    }
}