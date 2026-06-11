class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int i = dungeon.length - 1;
        int j = dungeon[0].length - 1;

        while(i >= 0 && j >= 0){
            int row = i;
            int column = j;
            while(row >= 0 && column <= dungeon[0].length - 1){
                int inherit = -1;
                inherit = column + 1 < dungeon[0].length ? dungeon[row][column + 1] : inherit;
                inherit = row + 1 < dungeon.length ? (inherit >= 0 ? Math.min(inherit, dungeon[row + 1][column]) : dungeon[row + 1][column]) : inherit;
                inherit = Math.max(0, inherit);
                int val = inherit - dungeon[row][column];
                dungeon[row][column] = Math.max(0, val);
                row--;
                column++;
            }
            if(j - 1 >= 0){
                j--;
            } else if(i - 1 >= 0){
                i--;
            } else {
                break;
            }
        }
        return dungeon[0][0] + 1;
    }
}