class Solution {
    class Pair{
        int i;
        int j;
        int t;
        public Pair(int i, int j, int t){
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int freshCnt = 0;
        int vis[][] = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                    vis[i][j] = 2;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1){
                    freshCnt++;
                }
            }
        }
        int tm = 0;
        int cnt = 0;
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int i = pair.i;
            int j = pair.j;
            int t = pair.t;
            tm = Math.max(tm,t);
            for(int k=0; k<4; k++){
                int row = i + drow[k];
                int col = j + dcol[k];
                if(row>=0 && col>=0 && row<m && col<n && vis[row][col]==0 && grid[row][col]==1){
                    q.offer(new Pair(row,col,t+1));
                    vis[row][col] = 2;
                    cnt++;
                }
            }
        }
        if(cnt!=freshCnt)return -1;
        return tm;
    }
}