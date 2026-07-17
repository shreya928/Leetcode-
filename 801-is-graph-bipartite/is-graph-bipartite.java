class Solution {
    public boolean isBipartite(int[][] graph) {
       int color[] = new int[graph.length];
       Arrays.fill(color,-1);
       for(int i = 0; i < graph.length; i++){
            if(color[i] == -1){
                if(!helper(i, graph, color, 0))return false;
            }
        }
        return true;
    }
    public boolean helper(int node, int graph[][], int color[], int currClr){
        color[node] = currClr;
        for(int neigh : graph[node]){
            if(color[neigh]==currClr){
                return false;
            }if(color[neigh]==-1){
                int clr = (currClr == 0 )? 1 : 0;
                if(!helper(neigh,graph,color,clr))return false;
            }
        }
        return true;
    }
}