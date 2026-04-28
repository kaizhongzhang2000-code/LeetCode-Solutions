class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[amount + 1][coins.length];
        Arrays.fill(memo[0], 1);
        //Arrays.sort(coins);
        for(int i = 1; i <= amount; i++){
            int count = 0;
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0){
                    count += memo[i - coins[j]][j];
                }
                memo[i][j] = count;
            }
        }
        return memo[amount][coins.length - 1];

    }
} 

// 0 1 1 1
// 1 1 1 1
// 2 1 2 2
// 3 1 2 2
// 4 1 3 3
// 5 1 3 4
// 6 1 4 5
// 7 1 4 6
// 8 1 5 7
// 9 1 5 8
// 10 1 6 10