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
        ListNode copy = head;
        int length = 1;
        while(copy.next != null){
            copy = copy.next;
            length++;
        }
        ListNode traverse = head;
        ListNode firstNode = head;
        int processed = 0;
        while(processed + k <= length){
            ListNode holder = null;
            ListNode nextNode;
            ListNode firstNodeHolder = traverse;
            for(int i = 0; i < k; i++){
                nextNode = traverse.next;
                traverse.next = holder;
                holder = traverse;
                traverse = nextNode;
            }
            if(processed == 0){
                head = holder;
            } else {
                firstNode.next = holder;
            }
            firstNode = firstNodeHolder;
            processed += k;
        }
        if(processed < length){
            firstNode.next = traverse;
        }
        return head;
    }
}