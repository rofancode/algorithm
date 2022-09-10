/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // 서로 다른 속도 출발하는 node를 만들고
        // cycle이라면 결국에 돌고돌아서 두 node가 만나는 지점이 생길것
        // cycle이 아니라면 빠른쪽이 먼저 null 에 도착하겠지.
        if (fast == null || fast.next == null) return false;
        
        slow = slow.next;
        fast = fast.next.next;
        
        while (fast != null && fast.next != null) {
            //같은 것을 찾을 때만 true return 
            if(slow == fast) 
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return false;
    }
}