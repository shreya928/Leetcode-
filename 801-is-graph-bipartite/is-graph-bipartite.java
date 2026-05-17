class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0; i<graph.length; i++){
            if(color[i]==-1){
                if(dfs(i, graph, color, 0)==false)return false;
            }
        }
        return true;
    }
    public boolean dfs(int node, int graph[][], int color[], int currCol){
        color[node] = currCol;
        for(int neigh :graph[node]){
            if(color[neigh] == currCol){
                return false;
            }
            if(color[neigh]==-1){
                int col = (currCol==0) ? 1 : 0;
                if(dfs(neigh, graph, color, col) == false)return false;
            }
        }
        return true;
    }
}