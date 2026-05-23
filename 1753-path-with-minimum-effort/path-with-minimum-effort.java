class Solution {
    class Pair{
        int diff;
        int x;
        int y;
        public Pair(int diff, int x, int y){
            this.diff = diff;
            this.x = x;
            this.y = y;
        }
    }
    int dx[] = {-1, 0, 1, 0};
    int dy[] = {0, 1, 0, -1};
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.diff, b.diff)
        );
        int m = heights.length;
        int n = heights[0].length;
        int dist[][] = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        pq.offer(new Pair(0,0,0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int diff = p.diff;
            int x = p.x;
            int y = p.y;
            if(x==m-1 && y==n-1){
                return diff;
            }
            for(int k=0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx>=0 && nx<m && ny>=0 && ny<n){
                    int newDiff = Math.max(Math.abs(heights[x][y]-heights[nx][ny]), diff);
                    if(newDiff<dist[nx][ny]){
                        pq.offer(new Pair(newDiff,nx,ny));
                        dist[nx][ny] = newDiff;
                    }
                }
            }
        }
        return 0;
    }
}