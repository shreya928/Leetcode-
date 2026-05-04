class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int V = isConnected.length;
        boolean vis[] = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                count++;
                dfsHelper(i, vis, isConnected);
            }
        }
        return count;
    }
    public void dfsHelper(int i, boolean vis[], int[][] isConnected){
        vis[i] = true;
        for(int j=0; j<isConnected.length; j++){
            if(isConnected[i][j]==1 && !vis[j]){
                dfsHelper(j, vis, isConnected);
            }
        }
    }
}