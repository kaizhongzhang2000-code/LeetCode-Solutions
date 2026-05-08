/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node pHolder = p;
        Node qHolder = q;
        while(p.val != q.val){
            p = p.parent == null ? qHolder : p.parent;
            q = q.parent == null ? pHolder : q.parent;
        }
        return p;
    }
}