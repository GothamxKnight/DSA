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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        head=head.next;
        while(head!=null){
            int sum=0;
            while(head.val!=0){
                sum+=head.val;
                head=head.next;
            }
            ListNode temp=new ListNode(sum);
            curr.next=temp;
            curr=curr.next;
            head=head.next;
        }
        return dummy.next;
    }
}