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
    Map<Integer, Integer> countMap = new HashMap<>();
    public int kthSmallest(TreeNode root, int k) {
        findTreeSize(root);
        return dfs(root, k);
    }

    public int dfs(TreeNode root, int k){
        int left = root.left != null ? countMap.get(root.left.val) : 0;
        if(left < k - 1){
            return dfs(root.right, k - left - 1);
        } else if(left > k - 1){
            return dfs(root.left, k);
        } else{
            return root.val;
        }
    }
    public int findTreeSize(TreeNode root){
        if(root == null){
            return 0;
        }
        int count = 1 + findTreeSize(root.left) + findTreeSize(root.right);
        countMap.put(root.val, count);
        return count;

    }
}