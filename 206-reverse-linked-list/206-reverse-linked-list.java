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
        // 변경할 때, 1 -> 2 을 2 -> 1 로 바꿔야함 . 
        // 2 target 일 때 2 -> 1 로 바꾸면 2의 next에 대한 정보를 모르게 됨
        // 과거 node에 대한 정보도 알고있어야함 
        
        // 1. 과거 node 2.원래 target의 next node. 3 target
        
         
        // target = curr 
        // 2의 next(3) curr에 저장 
        // 2의 next를 prev 에 저장된 1로 변경
        // prev = target 저장. 
        
        //처음의 경우
        //1일 때 target = curr = head;
        //next는 null 이 되어야 하므로. 처음에 prev = null로 초기화 
        //끝인 경우
        //curr.next == null 일 때 까지 작업을 해야해서 
        //prev = 4, curr = 5, next = null
        //curr - null, 4로 변경 prev = 5 
        //prev 값을 return 
        if (head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null ) {
            ListNode target = curr;
            curr = target.next; //다음 처리할 node
            target.next = prev; //next 변경
            prev = target;
        }
        
        return prev;
    }
    
    //time complexity O(N) / space complexity O(1)
}