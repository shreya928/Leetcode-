class Disjoint{
    int par[];
    int rank[];
    public Disjoint(int n){
        par = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            par[i] = i;
        }
    }
    public int findPar(int node){
        if(node==par[node])return node;
        return findPar(par[node]);
    }
    public void findUnion(int u, int v){
        int parent_u = findPar(u);
        int parent_v = findPar(v);
        if(parent_u == parent_v)return;

        if(rank[parent_u]<rank[parent_v]){
            par[parent_u] = parent_v;
        }else if(rank[parent_v]<rank[parent_u]){
            par[parent_v] = parent_u;
        }else{
            par[parent_v] = parent_u;
            rank[parent_u]++;
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {

        if(n-1>connections.length)return -1;

        Disjoint ds = new Disjoint(n);
        int extra_edges = 0;
        for(int i=0; i<connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.findPar(u) == ds.findPar(v)){
                extra_edges++;
            }else{
                ds.findUnion(u,v);
            }
        }

        int compo = 0;
        for(int i=0; i<n; i++){
            if(i == ds.findPar(i))compo++;
        }
        return (extra_edges >= compo-1) ? compo-1 : -1;
    }
}