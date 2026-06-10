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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // String left = "";
        // String right = "";
        List<Character> left = new ArrayList<>();
        List<Character> right = new ArrayList<>();
        dfs(root, startValue, destValue, left, right);
        Collections.reverse(right);
        String result = "";
        for(char c : left){
            result = result + c;
        }
        for(char c : right){
            result = result + c;
        }
        return result;
    }

    public boolean[] dfs(TreeNode root, int startValue, int destValue, List<Character> leftString, List<Character> rightString){
        boolean[] result = new boolean[2];
        if(root.val == startValue){
            result[0] = true;
        }
        if(root.val == destValue){
            result[1] = true;
        }
        if(root.left != null && (result[0] != true || result[1] != true)){
            boolean[] leftBoolean = dfs(root.left, startValue, destValue, leftString, rightString);
            if(leftBoolean[0] && leftBoolean[1]){
                return leftBoolean;
            } else if(leftBoolean[0]){
                result[0] = true;
                leftString.add('U');
            } else if(leftBoolean[1]){
                result[1] = true;
                rightString.add('L');
            }
        }
        if(root.right != null && (result[0] != true || result[1] != true)){
            boolean[] rightBoolean = dfs(root.right, startValue, destValue, leftString, rightString);
            if(rightBoolean[0] && rightBoolean[1]){
                return rightBoolean;
            } else if(rightBoolean[0]){
                result[0] = true;
                leftString.add('U');
            } else if(rightBoolean[1]){
                result[1] = true;
                rightString.add('R');
            }
        }
        return result;
    }
}