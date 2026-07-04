class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int prev[] = new int [amount+1];
        for(int j=1; j<amount+1; j++){
            prev[j] = (int)1e9;
        }
        for(int i=1; i<n+1; i++){
            int curr[] = new int[amount+1];
            for(int j=1; j<amount+1; j++){
                int val = coins[i-1];
                if(val<=j){
                    curr[j] = Math.min(1 + curr[j-val], prev[j]);
                }else{
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        return prev[amount] == 1e9 ? -1 : prev[amount];
    }
}