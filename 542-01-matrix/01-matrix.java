class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int di[] = {0, 1};
        int dj[] = {-1, 0};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
               if(mat[i][j]==0){
                q.offer(new int[]{i,j});
               }else{
                mat[i][j] = -1;
               }
            }
        }
        int drow[] = {0, -1, 0, 1};
        int dcol[] = {-1, 0, 1, 0};
        while(!q.isEmpty()){
            int pair[] = q.poll();
            int row = pair[0];
            int col = pair[1];
            for(int i=0; i<4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && mat[nrow][ncol]==-1){
                    mat[nrow][ncol] = mat[row][col] + 1;
                    q.offer(new int[]{nrow,ncol});
                }
            }
        }
        return mat;
    }
}