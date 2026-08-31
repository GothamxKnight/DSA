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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> critpoints=new ArrayList<>();
        ListNode prev=head;
        ListNode curr=head.next;
        int i=1;
        while(curr.next!=null){
            if(prev.val<curr.val && curr.val>curr.next.val){
                critpoints.add(i);
            }
            if(prev.val>curr.val && curr.val<curr.next.val){
                critpoints.add(i);
            }
            i++;
            curr=curr.next;
            prev=prev.next;
        }
        if(critpoints.size()==0|| critpoints.size()==1)return new int[]{-1,-1};

        int max=critpoints.get(critpoints.size()-1)-critpoints.get(0);
        int min=max;
        for(i=1;i<critpoints.size();i++){
            min=Math.min(min,critpoints.get(i)-critpoints.get(i-1));
        }
        return new int[]{min,max};

    }
}