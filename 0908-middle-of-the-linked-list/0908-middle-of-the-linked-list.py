# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        traverse = head
        length = 0
        while not traverse is None:
            length += 1
            traverse = traverse.next
        pos = 0
        while pos in range(length // 2):
            pos += 1
            head = head.next
        return head

            