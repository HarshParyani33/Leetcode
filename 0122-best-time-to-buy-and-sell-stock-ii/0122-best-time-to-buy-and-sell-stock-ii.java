class Solution {
    public int fun(int[] prices, int n, int i, int k, int[][] dp){
        if(i==n || k==0){
            return 0;
        }
        if(dp[i][k] != -1) return dp[i][k];
        if(k==2){
            int c1 = fun(prices, n, i+1, k-1, dp) -prices[i];
            int c2 = fun(prices, n, i+1, k, dp);
            return dp[i][k] = Math.max(c1, c2);
        }
        else{
            int c1 = fun(prices, n, i+1, k+1, dp) +prices[i];
            int c2 = fun(prices, n, i+1, k, dp);
            return dp[i][k] = Math.max(c1, c2);
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][3];
        for(int i=0; i<n;i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
            dp[i][2] = -1;
        }

        return fun(prices, n, 0, 2, dp);
    }
}