/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Map<Node, Integer> randomMap = new HashMap<>();
        List<Node> nodeList = new ArrayList<>();
        Node copyHead = new Node(head.val);
        Node result = copyHead;
        Node holder = copyHead;
        Node origHolder = head;
        int counter = 0;
        nodeList.add(copyHead);
        while(head != null){
            if(head.next != null){
                Node newNode = new Node(head.next.val);
                nodeList.add(newNode);
                copyHead.next = newNode;
            }
            randomMap.put(head, counter);
            copyHead = copyHead.next;
            head = head.next;
            counter++;
        }
        counter = 0;
        while(origHolder != null){
            Node random = origHolder.random;
            if(random != null){
                int randomIndex = randomMap.get(random);
                holder.random = nodeList.get(randomIndex);
            }
            origHolder = origHolder.next;
            holder = holder.next;
        }
        return result;
        
    }
}