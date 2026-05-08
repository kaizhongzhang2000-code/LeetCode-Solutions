class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for(int row : rows){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[row][j] != 0){
                    matrix[row][j] = 0;
                }
            } 
        }

        for(int column : columns){
            for(int i = 0; i < matrix.length; i++){
                if(matrix[i][column] != 0){
                    matrix[i][column] = 0;
                }
            } 
        }

        return;
    }
}