class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(find(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean find(char[][] board, String word, int i, int j, int idx){
        if(i<0 || i>=board.length ||
           j<0 || j>=board[0].length ||
           board[i][j] != word.charAt(idx)){

            return false;
        }
        if(idx == word.length()-1){
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '#';
        int row[] = {-1, 0, 1, 0};
        int col[] = {0, 1, 0, -1};
        for(int k=0; k<4; k++){
            int nrow = i + row[k];
            int ncol = j + col[k];
            if(nrow>=0 && nrow<board.length && ncol>=0 && ncol<board[0].length){
                if(find(board, word, nrow, ncol, idx+1)){
                    return true;
                }
            }
        }
        board[i][j] = temp;
        return false;
    }
}