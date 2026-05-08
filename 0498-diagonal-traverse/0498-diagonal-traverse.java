class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int row = 0;
        int col = 0;
        int[] result = new int[mat.length * mat[0].length];
        int index = 0;
        while(row < mat.length && col < mat[0].length){
            result[index] = mat[row][col];
            index++;
            if((row + col) % 2 == 0){
                col++;
                row--;
                if(col >= mat[0].length){
                    row += 2;
                    col -= 1;
                } else if(row < 0){
                    row += 1;
                }
            } else {
                col--;
                row++;
                if(row >= mat.length){
                    col += 2;
                    row -= 1;
                } else if(col < 0){
                    col += 1;
                } 
            }
        }
        return result;
    }
}