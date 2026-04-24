class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    int upLeft = (i - 1 >= 0 && j - 1 >= 0) ? memo[i - 1][j - 1] : 0;
                    int left = j - 1 >= 0 ? memo[i][j - 1] : 0;
                    int up = i - 1 >= 0 ? memo[i - 1][j] : 0;
                    int low = Math.min(upLeft, left);
                    int curr = Math.min(low, up) + 1;
                    if(curr > max){
                        max = curr;
                    }
                    memo[i][j] = curr;
                }
            }
        }
        return max * max;   
    }
}