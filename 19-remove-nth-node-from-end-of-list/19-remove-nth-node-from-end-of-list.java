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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //선두주자를 N만큼 먼저보내고 
        //다음주자를 보낸다. 
        //선두주자의 next가 null일 때 
        //다음주자가 next를 replace할 위치에 도착 -> replace . 다음주자의 next = next.next
        //if (head.next == null) return head.next; //1개뿐일 때
        
        ListNode first = head;
        while(n > 0) {
            n--;
            first = first.next;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode second = dummy;
        
        while(first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        
        return dummy.next;
    }
}