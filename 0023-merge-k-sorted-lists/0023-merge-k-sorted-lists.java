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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> {
            int compare = a.val - b.val;
            return compare;
        });
        for(ListNode node : lists){
            if(node != null){
                heap.offer(node);
            }
        }
        ListNode head = new ListNode();
        ListNode result = head;
        while(heap.size() > 0){
            ListNode node = heap.poll();
            head.next = node;
            head = head.next;
            if(node.next != null){
                heap.offer(node.next);
            }
        }
        return result.next;
    }
}