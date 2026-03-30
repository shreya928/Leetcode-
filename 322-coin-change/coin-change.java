class Solution {
    public int coinChange(int[] coins, int amount) {
        int curr[] = new int[amount+1];
        int prev[] = new int[amount+1];
        Arrays.fill(prev, (int)1e9);
        prev[0] = 0;
        for(int i=1; i<coins.length+1; i++){
            for(int j=0; j<amount+1; j++){
                if(coins[i-1]<=j){
                    curr[j] = Math.min(prev[j], curr[j-coins[i-1]]+1);
                }else{
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        return prev[amount] == 1e9 ? -1 : prev[amount];
    }
}