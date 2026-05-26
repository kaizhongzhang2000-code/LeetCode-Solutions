class LRUCache {
    int capacity;
    ListNode start = new ListNode();
    ListNode end = new ListNode();
    Map<Integer, ListNode> nodeMap = new HashMap<>();
    public LRUCache(int capacity) {
        this.start.next = this.end;
        this.end.prev = this.start;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return -1;
        }
        ListNode currNode = nodeMap.get(key);
        ListNode prevNode = currNode.prev;
        ListNode nextNode = currNode.next;
        ListNode newPrev = this.end.prev;
         if(!newPrev.equals(currNode)){
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            newPrev.next = currNode;
            currNode.prev = newPrev;
            currNode.next = this.end;
            this.end.prev = currNode;
         }
        return currNode.val;
    }
    
    public void put(int key, int value) {
        if(nodeMap.containsKey(key)){
            ListNode currNode = nodeMap.get(key);
            ListNode prevNode = currNode.prev;
            ListNode nextNode = currNode.next;
            ListNode newPrev = this.end.prev;
            if(!newPrev.equals(currNode)){
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
                newPrev.next = currNode;
                currNode.prev = newPrev;
                currNode.next = this.end;
                this.end.prev = currNode;
            }
            currNode.val = value;
        } else if (nodeMap.keySet().size() >= this.capacity){
            ListNode remove = this.start.next;
            ListNode newFirst = remove.next;
            this.start.next = newFirst;
            newFirst.prev = this.start;
            nodeMap.remove(remove.key);
            ListNode newNode = new ListNode(key, value);
            ListNode prevNode = this.end.prev;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = this.end;
            this.end.prev = newNode;
            nodeMap.put(key, newNode);
        } else {
            ListNode newNode = new ListNode(key, value);
            ListNode prevNode = this.end.prev;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = this.end;
            this.end.prev = newNode;
            nodeMap.put(key, newNode);
        }
    }
}

class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;
    public ListNode(){

    }

    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */