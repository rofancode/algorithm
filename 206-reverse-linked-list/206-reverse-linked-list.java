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
    public ListNode reverseList(ListNode head) {
        // 뒤에서 부터 4 <- 5 , 3 <- 4 <- 5 로 변경하기 
        // 5에서 next 지정하려면 4 에 대한 정보가 있어야 함
        // 4에서 5 next변경 -> 자신의 next = null 
        // 재귀 방식으로 먼저 next 호출하고 next의 next가 null일때 next변경
        // 첫번째의 경우 자신의 next는 null로 변경. okay 
        // 2개 있는 경우도 okay
        // head가 null이거나 마지막 head일때 head return
        if (head == null || head.next == null) return head;
        
        ListNode newHead = reverseList(head.next);
    
        //next 변경 
        head.next.next = head;
        head.next = null;
        return newHead;
        
    }
    
    //time complexity O(N) / space complexity O(N)
}