class Solution {
    public int findCircleNum(int[][] isConnected) {
        int vis[] = new int[isConnected.length];
        int ans=0;
        for(int i = 0; i < isConnected.length; i++) {
            if(vis[i] == 0) {
                helper(isConnected, vis, i);
                ans++;
            }
        }
        return ans;
    }
    public void helper(int[][] isConnected, int[] vis, int node){
        vis[node] = 1;
        for(int i=0; i<isConnected[0].length; i++){
            if(isConnected[node][i]==1 && vis[i]==0){
                helper(isConnected,vis,i);
            }
        }
    }
}