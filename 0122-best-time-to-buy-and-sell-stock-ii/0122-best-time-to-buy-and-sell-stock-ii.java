class Solution {
    public int maxProfit(int[] prices) {
        int dip = -1;
        int profit = 0;
        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i + 1] > prices[i]){
                if(dip < 0){
                    dip = prices[i];
                }
            } else if(prices[i + 1] < prices[i]){
                if(dip >= 0){
                    profit += prices[i] - dip;
                    dip = -1;
                }
            }
        }
        if(dip >= 0){
            profit += prices[prices.length - 1] - dip;
        }
        return profit;
    }
}