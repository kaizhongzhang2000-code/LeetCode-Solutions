/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "[]";
        }
        Queue<TreeNode> process = new LinkedList<>();
        process.offer(root);
        StringBuilder sb = new StringBuilder("[");
        sb.append(root.val);
        StringBuilder pendingNull = new StringBuilder();
        while(!process.isEmpty()) {
            TreeNode node = process.poll();
            if(node.left == null){
                pendingNull.append(",");
                pendingNull.append("null");
            } else if (node.left != null){
                sb.append(pendingNull.toString());
                pendingNull = new StringBuilder();
                sb.append(",");
                sb.append(node.left.val);
                process.offer(node.left);
            }
            if(node.right == null){
                pendingNull.append(",");
                pendingNull.append("null");
            } else if (node.right != null){
                sb.append(pendingNull.toString());
                pendingNull = new StringBuilder();
                sb.append(",");
                sb.append(node.right.val);
                process.offer(node.right);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        Queue<TreeNode> parents = new LinkedList<>();
        TreeNode pendingNode = null;
        int multiplier = 1;
        for(int i = 0; i < data.length(); i++){
            if(data.charAt(i) >= '0' && data.charAt(i) <= '9'){
                int sum = data.charAt(i) - '0';
                while(i + 1 < data.length() && data.charAt(i + 1) >= '0' && data.charAt(i + 1) <= '9'){
                    i++;
                    sum = sum * 10 + data.charAt(i) - '0';
                }
                sum = sum * multiplier;
                if(root != null) {
                    TreeNode node = new TreeNode(sum);
                    if(pendingNode != null){
                        pendingNode.right = node;
                        pendingNode = null;
                    } else {
                        pendingNode = parents.poll();
                        pendingNode.left = node;
                    }
                    parents.offer(node);
                } else {
                    root = new TreeNode(sum);
                    parents.offer(root);
                } 
                multiplier = 1;
            } else if(data.charAt(i) == 'n'){
                i += 3;
                if(pendingNode != null){
                    pendingNode.right = null;
                    pendingNode = null;
                } else {
                    pendingNode = parents.poll();
                    pendingNode.left = null;
                }
            } else if (data.charAt(i) == '-') {
                multiplier = -1;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));