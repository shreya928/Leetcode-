class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] =  new int[m][n];
        int k=0,l=0;
        while(l<n && obstacleGrid[0][l]!=1)dp[0][l++] = 1;
        while(k<m && obstacleGrid[k][0]!=1)dp[k++][0] = 1;
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j]!=1){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}