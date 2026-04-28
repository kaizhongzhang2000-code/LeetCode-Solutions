/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> toProcess = new LinkedList<>();
        List<TreeNode> candidates = new ArrayList<>();
        List<Integer> currLevel = new ArrayList<>();
        toProcess.add(root);
        while(toProcess.size() > 0){
            TreeNode node = toProcess.poll();
            currLevel.add(node.val);
            if(node.left != null){
                candidates.add(node.left);
            }
            if(node.right != null){
                candidates.add(node.right);
            }
            if(toProcess.size() == 0){
                toProcess.addAll(candidates);
                candidates.clear();
                result.add(currLevel);
                currLevel = new ArrayList<>();
            }
        }
        Collections.reverse(result);
        return result;
    }
}