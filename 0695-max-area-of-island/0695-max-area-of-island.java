class Solution {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    public boolean valid(int i,int j,int n,int m){
        if(i>=n || j>=m || i<0 || j<0){
            return false;
        }
        return true;
    }
    public int dfs(int[][] grid, boolean[][]vis, int n, int m, int i, int j,int a){
        int count = 1;
        vis[i][j] = true;
        for(int k=0; k<4; k++){
            int row = i + x[k];
            int col = j+y[k];
            if(valid(row,col,n,m) && grid[row][col]==1 && !vis[row][col]){
               count  +=  dfs(grid,vis,n,m,row,col,a);
            }
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int MaxArea =0;
        for(int i=0; i<n; i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    MaxArea = Math.max(MaxArea, dfs(grid,vis,n,m,i,j,0));
                }
            }
        }
        return MaxArea;

    }
}