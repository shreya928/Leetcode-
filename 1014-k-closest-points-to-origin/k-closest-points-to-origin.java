class Solution {
    class Pair{
        int idx;
        int dist;
        public Pair(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int ans[][] = new int[k][2];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.dist, a.dist)
        );
        for(int i=0; i<points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int distance = x * x + y * y;
            pq.offer(new Pair(i,distance));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int i=0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int idx = p.idx;
            ans[i][0] = points[idx][0];
            ans[i][1] = points[idx][1];
            i++;
        }
        return ans;
    }
}