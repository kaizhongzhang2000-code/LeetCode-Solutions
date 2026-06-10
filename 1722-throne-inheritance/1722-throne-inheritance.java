class ThroneInheritance {
    TreeNode king;
    Map<String, TreeNode> nodeMap = new HashMap<>();
    public ThroneInheritance(String kingName) {
        this.king = new TreeNode(kingName);
        nodeMap.put(kingName, this.king);
    }
    
    public void birth(String parentName, String childName) {
        TreeNode child = new TreeNode(childName);
        TreeNode parent = this.nodeMap.getOrDefault(parentName, new TreeNode(parentName));
        parent.kids.add(child);
        this.nodeMap.put(parentName, parent);
        this.nodeMap.put(childName, child);
    }
    
    public void death(String name) {
        TreeNode dier = this.nodeMap.get(name);
        dier.dead = true;
    }
    
    public List<String> getInheritanceOrder() {
        TreeNode traversal = this.king;
        List<String> result = new ArrayList<>();
        dfs(traversal, result);
        return result;
    }

    public void dfs(TreeNode traversal, List<String> result){
        if(!traversal.dead){
            result.add(traversal.val);
        }
        for(TreeNode node : traversal.kids){
            dfs(node, result);
        }
        return;
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */

 class TreeNode {
    String val;
    List<TreeNode> kids = new ArrayList<>();
    boolean dead = false;

    public TreeNode() {

    }

    public TreeNode(String val){
        this.val = val;
    }
 }