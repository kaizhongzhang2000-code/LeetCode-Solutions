/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        Node result = null;
        Map<Integer, Node> nodeMap = new HashMap<>();
        Queue<Node> nodeToProcess = new LinkedList<>();
        Set<Node> processed = new HashSet<>();
        nodeToProcess.offer(node);
        processed.add(node);
        while(nodeToProcess.size() > 0){
            Node curr = nodeToProcess.poll();
            Node copy;
            if(nodeMap.containsKey(curr.val)){
                copy = nodeMap.get(curr.val);
            } else {
                copy = new Node(curr.val);
            }
            for(Node neighbor : curr.neighbors){
                Node neighborCopy;
                if(nodeMap.containsKey(neighbor.val)){
                    neighborCopy = nodeMap.get(neighbor.val);
                } else {
                    neighborCopy = new Node(neighbor.val);
                    nodeMap.put(neighbor.val, neighborCopy);
                }
                copy.neighbors.add(neighborCopy);
                if(!processed.contains(neighbor)){
                    nodeToProcess.offer(neighbor);
                    processed.add(neighbor);
                }
            }
            nodeMap.put(curr.val, copy);
            if(result == null){
                result = copy;
            }
        }
        return result;
    }
}