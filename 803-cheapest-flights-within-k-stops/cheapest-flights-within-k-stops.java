class Solution {

    class Pair{
        int city;
        int cost;

        Pair(int city,int cost){
            this.city=city;
            this.cost=cost;
        }
    }

    class Pair1{
        int node;
        int totCost;
        int stops;

        Pair1(int node,int totCost,int stops){
            this.node=node;
            this.totCost=totCost;
            this.stops=stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        ArrayList<Pair>[] adj = new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] f:flights){
            adj[f[0]].add(new Pair(f[1],f[2]));
        }

        Queue<Pair1> q=new LinkedList<>();
        q.offer(new Pair1(src,0,0));

        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        while(!q.isEmpty()){

            Pair1 curr=q.poll();

            int node=curr.node;
            int cost=curr.totCost;
            int stops=curr.stops;

            if(stops>k) continue;

            for(Pair nei:adj[node]){

                int next=nei.city;
                int newCost=cost+nei.cost;

                if(newCost < dist[next]){

                    dist[next]=newCost;

                    q.offer(
                        new Pair1(
                            next,
                            newCost,
                            stops+1
                        )
                    );
                }
            }
        }

        return dist[dst]==Integer.MAX_VALUE ? -1 : dist[dst];
    }
}