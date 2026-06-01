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
        if(length(head)<=2){
            return;
        }
        ListNode p1=head;
        ListNode p2=head.next;
        ListNode p3=new ListNode(0);
        p3.next=head;
        ListNode p4=head;
        while(p4.next!=null){
            p4=p4.next;
            p3=p3.next;
        }
        p3.next=null;
        p1.next=p4;
        p4.next=p2;
        reorderList(p2);
    }
    static int length(ListNode head){
        ListNode temp=head;
        int len=0;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        return len;
    }
}