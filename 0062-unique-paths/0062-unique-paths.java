class Solution {
    // public int fun(int i, int j, int n, int m, int[][] dp){
    //     if(i==n-1 || j==m-1) return 1;
    //     if(i<0 || j<0 || i>=n || j>=m) return 0;
    //     if(dp[i][j] != -1 ) return dp[i][j];
    //     return dp[i][j] = fun(i+1, j, n,m,dp) + fun(i,j+1, n,m,dp);
    // }
    public int uniquePaths(int m, int n) {
        // int[][] dp = new int[n][m];
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // return fun(0,0,n,m,dp);
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++){
            dp[i][m-1] = 1;
        }
        for(int i=0; i<m; i++){
            dp[n-1][i] = 1;
        }
        for(int i=n-2; i>=0;i--){
            for(int j=m-2; j>=0; j--){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}