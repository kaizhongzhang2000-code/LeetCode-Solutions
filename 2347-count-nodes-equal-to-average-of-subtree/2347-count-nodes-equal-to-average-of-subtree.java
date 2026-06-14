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
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        calcSum(root);
        return count;
    }

    public int[] calcSum(TreeNode root) {
        if(root == null){
            return new int[]{0, 0};
        }
        int[] left = calcSum(root.left);
        int[] right = calcSum(root.right);
        int[] result = new int[]{1 + left[0] + right[0], root.val + left[1] + right[1]};
        if(root.val == result[1] / result[0]){
            count++;
        }
        return result;
    }
}