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
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for(int i=0; i<n; i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        Disjoint dj = new Disjoint(maxRow + maxCol + 2);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            dj.findUnion(nodeRow,nodeCol);
            hm.put(nodeRow,1);
            hm.put(nodeCol,1);
        }
        int cnt = 0;
        for(Map.Entry<Integer,Integer> it : hm.entrySet()){
            if(dj.findPar(it.getKey())==it.getKey()){
                cnt++;
            }
        }
        return n-cnt;
    }
}