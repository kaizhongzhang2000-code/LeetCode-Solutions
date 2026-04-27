class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        int result = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                result = Math.max(result, dfs(matrix, memo, i, j, -1));
            }
        }

        return result;
    }

    public int dfs(int[][] matrix, int[][] memo, int i, int j, int min){
        if(matrix[i][j] <= min){
            return 0;
        }
        if(memo[i][j] > 0){
            return memo[i][j];
        }
        int curr = 1;
        int left = j - 1 >= 0 ? dfs(matrix, memo, i, j - 1, matrix[i][j]) : 0;
        int right = j + 1 < matrix[0].length ? dfs(matrix, memo, i, j + 1, matrix[i][j]) : 0;
        int up = i - 1 >=0 ? dfs(matrix, memo, i - 1, j, matrix[i][j]) : 0;
        int down = i + 1 < matrix.length ? dfs(matrix, memo, i + 1, j, matrix[i][j]) : 0;
        curr += Math.max(left, Math.max(right, Math.max(up, down)));
        memo[i][j] = curr;
        return curr;

    }
}