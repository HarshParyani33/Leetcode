class Solution {
    int[]x = new int[]{-1,1,0,0};
    int[]y = new int[]{0,0,-1,1};
    public boolean valid(int r,int c, int n,int m){
        if(r<0 || r>=n || c<0 || c>=m){
            return false;
        }
        return true;
    }
    public void dfs(char[][]board, int i, int j, int n, int m){
        board[i][j] = 'N';
        for(int k=0; k<4; k++){
            int row = i+x[k];
            int col = j+y[k];
            if(valid(row,col,n,m) && board[row][col]=='O'){
                dfs(board, row, col, n,m);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++){
            if(board[i][m-1] == 'O')
            dfs(board, i,m-1,n,m);
        }
        for(int i=0; i<n; i++){
            if(board[i][0] == 'O')
            dfs(board, i,0,n,m);
        }
        for(int i=0; i<m; i++){
            if (board[0][i] == 'O')
            dfs(board, 0,i,n,m);
        }
        for(int i=0; i<m; i++){
            if (board[n-1][i] == 'O')
            dfs(board, n-1,i,n,m);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'N'){
                    board[i][j] = 'O';
                }
                else{
                    board[i][j] = 'X';
                }
            }
        }
    }
}