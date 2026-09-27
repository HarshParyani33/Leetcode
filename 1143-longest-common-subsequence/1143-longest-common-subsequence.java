class Solution {
    // public int fun(String t1, String t2,int i, int j,int n, int m, int[][]dp){
    //     if(i==n || j==m) return 0;

    //     if(dp[i][j] != -1 ) return dp[i][j];

    //     if(t1.charAt(i) == t2.charAt(j)) {
    //         return dp[i][j] = 1+ fun(t1, t2, i+1, j+1, n,m,dp);
    //     }
    //     int c1 = fun(t1,t2,i+1,j,n,m,dp);
    //     int c2 = fun(t1,t2,i,j+1,n,m,dp);
    //     return dp[i][j] = Math.max(c1,c2);
    // }
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int n = text1.length();
    //     int m = text2.length();
    //     int[][] dp = new int[n+1][m+1];
    //     for(int i=0; i<=n; i++){
    //         for(int j=0; j<=m; j++){
    //             dp[i][j] = -1;
    //          }
    //     }
    //     return fun(text1, text2 ,0,0,n,m,dp);
    // }
    public int longestCommonSubsequence(String text1, String text2){
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i= n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }
                else{
                    int c1 = dp[i+1][j];
                    int c2 = dp[i][j+1];
                    dp[i][j] = Math.max(c1, c2);
                }
            }
        }
        return dp[0][0];
    }
}