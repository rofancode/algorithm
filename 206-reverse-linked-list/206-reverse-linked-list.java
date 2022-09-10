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
        // head가 null이거나 head가 1개밖에 없으면 head return
        if (head == null || head.next == null) return head;
        
        return reverse(head);
        
    }
    
    private ListNode reverse(ListNode node) {
        // 해당 node의 next의 next가 null일 때 head지정
        // 아니면 next를 호출할 거야
        // next 지정
        ListNode newHead = null;
        if (node.next.next == null) {
            newHead = node.next;
        } else {
            newHead = reverse(node.next);
        }
        //next 변경 
        node.next.next = node;
        node.next = null;
        
        return newHead;
    }
}