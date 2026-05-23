class Solution {
    class Pair {
        int x;
        int y;
        int len;

        Pair(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }

    int dx[] = {-1,-1,-1,0,0,1,1,1};
    int dy[] = {-1,0,1,-1,1,-1,0,1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] != 0 || grid[n-1][n-1] != 0)
            return -1;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0,0,1));
        grid[0][0] = 1; // mark visited

        while(!q.isEmpty()) {
            Pair p = q.poll();

            int x = p.x;
            int y = p.y;
            int len = p.len;

            if(x == n-1 && y == n-1)
                return len;

            for(int k=0; k<8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx>=0 && nx<n &&
                   ny>=0 && ny<n &&
                   grid[nx][ny]==0) {

                    grid[nx][ny]=1; // visited
                    q.offer(new Pair(nx,ny,len+1));
                }
            }
        }

        return -1;
    }
}