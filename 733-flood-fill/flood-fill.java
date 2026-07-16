class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int r, int c){
            this.row = r;
            this.col = c;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int clr = image[sr][sc];
        Queue<Pair> q = new LinkedList<>();
        int vis[][] = new int[n][m];
        q.offer(new Pair(sr,sc));
        image[sr][sc] = color;
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            vis[row][col] = 1;
            for(int i=0; i<4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==0 && image[nrow][ncol]==clr){
                    q.offer(new Pair(nrow,ncol));
                    image[nrow][ncol] = color;
                }
            }
        }
        return image;
    }
}