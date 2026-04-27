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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode();
        result.next = head;
        ListNode traverse = result;
        while(traverse.next != null){
            ListNode start = traverse.next;
            ListNode end = start.next;
            if(end != null && start.val == end.val){
                while(end != null && end.val == start.val){
                    start = start.next;
                    end = start.next;
                }
                traverse.next = end;
                continue;
            }
            traverse = traverse.next;
        }
        return result.next;
    }
}