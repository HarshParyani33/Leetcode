class Solution {
    public int fun(int[] prices, int n, int i, int k, int[][] dp){
        if(i==n || k==0){
            return 0;
        }
        if(dp[i][k] != -1) return dp[i][k];
        if(k%2 ==0){
            int c1 = fun(prices, n, i+1, k-1, dp) -prices[i];
            int c2 = fun(prices, n, i+1, k, dp);
            return dp[i][k] = Math.max(c1, c2);
        }
        else{
            int c1 = fun(prices, n, i+1, k-1, dp) +prices[i];
            int c2 = fun(prices, n, i+1, k, dp);
            return dp[i][k] = Math.max(c1, c2);
        }
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        k = k*2;
        int[][] dp = new int[n+1][k+1];
        for(int i=0; i<=n;i++){
           for(int j=0; j<=k; j++){
            dp[i][j] = -1;
           }
        }

        return fun(prices, n, 0, k, dp);
    }
}