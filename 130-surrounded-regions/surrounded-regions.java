class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<Pair> q = new LinkedList<>();
        for(int j=0; j<n; j++){
            if(board[0][j]=='O'){
                q.offer(new Pair(0,j));
                board[0][j] = '$';
            }
        }
        for(int i=1; i<m; i++){
            if(board[i][n-1]=='O'){
                q.offer(new Pair(i,n-1));
                board[i][n-1] = '$';
            }
        }
        for(int j=n-2; j>=0; j--){
            if(board[m-1][j]=='O'){
                q.offer(new Pair(m-1,j));
                board[m-1][j] = '$';
            }
        }
        for(int i=1; i<m-1; i++){
            if(board[i][0]=='O'){
                q.offer(new Pair(i,0));
                board[i][0] = '$';
            }
        }
        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            for(int i=0; i<4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && board[nrow][ncol]=='O'){
                    q.offer(new Pair(nrow,ncol));
                    board[nrow][ncol] = '$';
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }else if(board[i][j]=='$'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}