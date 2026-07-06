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
        if(head  == null) return head;
        ListNode left = head;
        ListNode right;
        ListNode prevLeft = null;
        ListNode res = null;
        while(true){
            right = left;
            for(int i=0; i<k-1; i++){
                if(right==null) break;
                right = right.next;
            }
            if(right !=null){
                ListNode nextLeft = right.next;
                reverse(left, k);
                if(prevLeft != null){
                    prevLeft.next = right;
                }
                prevLeft = left;

                if(res == null){
                    res = right;
                }
                left = nextLeft;
            }
            else{
                if(prevLeft != null){
                    prevLeft.next = left;
                }
                if(res == null) return left;
                break;
            }
           
        }
         return res;
    }
    public void reverse(ListNode left, int k){
        int times = k;
        ListNode prev = null;
        ListNode curr = left;
        while(times!=0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            times--;
        }
    }
}