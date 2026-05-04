class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int clr = image[sr][sc];
        if (clr == color) return image;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr, sc));
        image[sr][sc] = color;
        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int row = pair.row;
            int col = pair.col;
            for(int i=0; i<4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && image[nrow][ncol]==clr){
                    image[nrow][ncol] = color;
                    q.offer(new Pair(nrow,ncol));
                }
            }
        }
        return image;
    }
}