class Solution {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    public boolean valid(int i,int j,int n,int m){
        if(i>=n || j>=m || i<0 || j<0){
            return false;
        }
        return true;
    }
    public int dfs(int[][] grid, int n, int m, int i, int j){
        if(i<0 || j<0 || j>=m || i>=n || grid[i][j]==0){
            return 0;
        }
        grid[i][j] = 0;
        int count = 1;
        count += dfs(grid,n,m,i-1,j) + dfs(grid,n,m,i+1,j) + dfs(grid,n,m,i,j-1) + dfs(grid,n,m,i,j+1);
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int MaxArea =0;
        for(int i=0; i<n; i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    MaxArea = Math.max(MaxArea, dfs(grid,n,m,i,j));
                }
            }
        }
        return MaxArea;

    }
}