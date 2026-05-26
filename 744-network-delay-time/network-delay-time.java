class Solution {

    class Pair{
        int node;
        int time;

        Pair(int node,int time){
            this.node=node;
            this.time=time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<Pair>[] adj = new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] t:times){
            adj[t[0]].add(
                new Pair(t[1],t[2])
            );
        }

        PriorityQueue<Pair> pq =
            new PriorityQueue<>(
                (a,b)->a.time-b.time
            );

        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[k]=0;
        pq.offer(new Pair(k,0));

        while(!pq.isEmpty()){

            Pair curr=pq.poll();

            int node=curr.node;
            int currTime=curr.time;

            // skip outdated entries
            if(currTime > dist[node])
                continue;

            for(Pair neigh:adj[node]){

                int next=neigh.node;
                int newTime=currTime+neigh.time;

                if(newTime < dist[next]){

                    dist[next]=newTime;

                    pq.offer(
                        new Pair(next,newTime)
                    );
                }
            }
        }

        int ans=0;

        for(int i=1;i<=n;i++){

            if(dist[i]==Integer.MAX_VALUE)
                return -1;

            ans=Math.max(ans,dist[i]);
        }

        return ans;
    }
}