class Solution {
    class Pair{
        int node;
        long dis;
        public Pair(int node, long dis){
            this.node = node;
            this.dis = dis;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<Pair> adj[] = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int road[] : roads){
            adj[road[0]].add(new Pair(road[1],road[2]));
            adj[road[1]].add(new Pair(road[0],road[2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->Long.compare(a.dis , b.dis)
        );
        pq.offer(new Pair(0,0));
        long dist[] = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int ways[] = new int[n];
        dist[0] = 0;
        ways[0] = 1;
        int MOD=1000000007;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            long currDis = p.dis;
            if(currDis > dist[node]) continue;
            for(Pair neigh : adj[node]){
                if(dist[neigh.node]>currDis + neigh.dis){
                    pq.offer(new Pair(neigh.node, currDis + neigh.dis));
                    dist[neigh.node] = currDis + neigh.dis;
                    ways[neigh.node] = ways[node];
                }
                else if(dist[neigh.node]==currDis + neigh.dis){
                    ways[neigh.node] = (ways[neigh.node] + ways[node]) % MOD;
                }
            }
        }
        return ways[n-1];
    }
}