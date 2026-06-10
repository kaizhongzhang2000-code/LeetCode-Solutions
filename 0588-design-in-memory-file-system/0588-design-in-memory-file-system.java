class FileSystem {
    TreeNode root;
    public FileSystem() {
        this.root = new TreeNode();
        this.root.type = "dir";
    }
    
    public List<String> ls(String path) {
        String[] folders = path.split("/");
        TreeNode traversal = this.root;
        for(int i = 1; i < folders.length; i++){
            String folder = folders[i];
            TreeNode node = traversal.children.get(folder);
            traversal = node;
        }
        if(traversal.type.equals("file")){
            return List.of(traversal.name);
        } else {
            List<String> result = new ArrayList<>();
            for(TreeNode value : traversal.children.values()){
                result.add(value.name);
            }
            Collections.sort(result);
            return result;
        }
    }
    
    public void mkdir(String path) {
        String[] folders = path.split("/");
        TreeNode traversal = this.root;
        for(int i = 1; i < folders.length; i++){
            String folder = folders[i];
            TreeNode node = traversal.children.getOrDefault(folder, new TreeNode("dir", folder));
            traversal.children.put(folder, node);
            traversal = node;
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] folders = filePath.split("/");
        TreeNode traversal = this.root;
        for(int i = 1; i < folders.length; i++){
            String folder = folders[i];
            TreeNode node = traversal.children.getOrDefault(folder, new TreeNode("dir", folder));
            traversal.children.put(folder, node);
            traversal = node;
        }
        traversal.type = "file";
        traversal.content = traversal.content + content;
    }
    
    public String readContentFromFile(String filePath) {
        String[] folders = filePath.split("/");
        TreeNode traversal = this.root;
        for(int i = 1; i < folders.length; i++){
            String folder = folders[i];
            TreeNode node = traversal.children.get(folder);
            traversal = node;
        }
        return traversal.content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */

class TreeNode {
    String type;
    String name;
    String content = "";
    Map<String, TreeNode> children = new HashMap<>();
    public TreeNode(){

    }

    public TreeNode(String type, String name){
        this.type = type;
        this.name = name;
    }
}