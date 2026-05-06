class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        for(int j=0; j<n; j++){
            if(grid[0][j]==1){
                q.offer(new Pair(0,j));
                grid[0][j]=2;
            }
        }
        for(int i=1; i<m; i++){
            if(grid[i][n-1]==1){
                q.offer(new Pair(i,n-1));
                grid[i][n-1]=2;
            }
        }
        for(int j=0; j<n-1; j++){
            if(grid[m-1][j]==1){
                q.offer(new Pair(m-1,j));
                grid[m-1][j]=2;
            }
        }
        for(int i=1; i<m-1; i++){
            if(grid[i][0]==1){
                q.offer(new Pair(i,0));
                grid[i][0]=2;
            }
        }
        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            for(int k=0; k<4; k++){
                int nrow = row + drow[k];
                int ncol = col + dcol[k];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                    q.offer(new Pair(nrow,ncol));
                    grid[nrow][ncol] = 2;
                }
            }
        }
        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}