class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyprice = prices[0];
        for(int i=0; i<prices.length; i++){
            if(prices[i]<buyprice){
                buyprice = prices[i];
            }
            profit = Math.max(profit, prices[i]-buyprice);
        }
        return profit;
    }
}