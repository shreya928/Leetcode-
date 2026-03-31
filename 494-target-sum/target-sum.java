class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totSum = 0;
        for(int num:nums)totSum += num;
        if(Math.abs(target)> totSum || (totSum + target)%2 != 0)return 0;
        int newTar = (totSum + target)/2;
        int n = nums.length;
        int dp[][] = new int[n+1][newTar+1];
        dp[0][0] = 1;
        for(int i=1; i<n+1; i++){
            for(int j=0; j<newTar+1; j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j]; 
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][newTar];
    }
}