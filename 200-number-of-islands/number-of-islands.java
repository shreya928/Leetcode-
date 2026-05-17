class Solution {
    int ans = 0;
    int drow[] = {-1, 0, 1, 0};
    int dcol[] = {0, 1, 0, -1};
    public int numIslands(char[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    ans++;
                    grid[i][j] = '2';
                    find(grid, i, j);
                }
            }
        }
        return ans;
    }
    public void find(char[][] grid, int row, int col){
        for(int k=0; k<4; k++){
            int nrow = row + drow[k];
            int ncol = col + dcol[k];
            if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && grid[nrow][ncol]=='1'){
                grid[nrow][ncol] = '2';
                find(grid, nrow, ncol);
            }
        }
    }
}