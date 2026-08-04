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
    public void reorderList(ListNode head) {
        ListNode fast=head.next, slow=head;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode prev=null, curr=slow.next;
        slow.next=null;
        while (curr!=null) {
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        ListNode l1=head, l2=prev;
        while (l2!=null) {
            ListNode temp1=l1.next, temp2=l2.next;
            l1.next=l2;
            l2.next=temp1;
            l1=temp1;
            l2=temp2;
        }
    }
}
