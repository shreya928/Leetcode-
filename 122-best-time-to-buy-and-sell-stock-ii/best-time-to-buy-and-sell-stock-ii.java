class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int bp = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(prices[i]>bp){
                profit += prices[i]-bp;
            }
            bp = prices[i];
        }
        return profit;
    }
}