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
        var parent=new ListNode(-1,head);
        var result=parent;
        var node=head;
        while(node!=null){
            if(hashset.Contains(node.val)){
                parent.next=node.next;
            }
            else{
                parent=node;
            }
            node=node.next;
        }
        return result.next;
    }
}