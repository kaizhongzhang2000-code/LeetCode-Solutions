class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] memo = new boolean[board.length][board[0].length];
                    boolean exist = dfs(board, i, j, word, 0, memo);
                    if(exist){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] memo){
        if(memo[i][j]){
            return false;
        }
        if(index == word.length() - 1){
            return true;
        }
        memo[i][j] = true;
        if(i - 1 >= 0){
            if(board[i - 1][j] == word.charAt(index + 1)){
                if(dfs(board, i - 1, j, word, index + 1, memo)){
                    return true;
                }
            }
        }  
        if(i + 1 < board.length){
            if(board[i + 1][j] == word.charAt(index + 1)){
                if(dfs(board, i + 1, j, word, index + 1, memo)){
                    return true;
                }
            }
        } 
        if(j - 1 >= 0){
            if(board[i][j - 1] == word.charAt(index + 1)){
                if(dfs(board, i, j - 1, word, index + 1, memo)){
                    return true;
                }
            }
        }  
        if(j + 1 < board[0].length){
            if(board[i][j + 1] == word.charAt(index + 1)){
                if(dfs(board, i, j + 1, word, index + 1, memo)){
                    return true;
                }
            }
        }
        memo[i][j] = false;
        return false;
    }
}
// A B C E
// S F E S
// A D E E