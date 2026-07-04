class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        for(int j=1; j<amount+1; j++){
            dp[0][j] = (int)1e9;
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<amount+1; j++){
                int val = coins[i-1];
                if(val<=j){
                    dp[i][j] = Math.min(1 + dp[i][j-val], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount] == 1e9 ? -1 : dp[n][amount];
    }
}