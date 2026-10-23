class Pair{
    int i;
    int j;
    public Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j));
                }else{
                    mat[i][j] =-1;
                }
            }
        }
        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};
        int r = mat.length;
        int c = mat[0].length;
        while(!q.isEmpty()){
            Pair p =q.poll();
            for(int k=0; k<4; k++){
                int nx = p.i + dx[k];
                int ny = p.j + dy[k];
                if(nx>=0 && nx<r && ny>=0 && ny<c && mat[nx][ny]==-1){
                    q.offer(new Pair(nx,ny));
                    mat[nx][ny] =mat[p.i][p.j]+1;
                }
            }
        }
        return mat;
    }
}