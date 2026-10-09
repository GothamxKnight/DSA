class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int dp[][]=new int[k+1][n+1];
        for(int i=1;i<k+1;i++){
            for(int j=1;j<=n;j++){
                for(int l=j+1;l<=n;l++){
                    dp[i][l]=Math.max(dp[i][l],Math.max(dp[i][l-1],dp[i-1][j-1]+prices[l-1]-prices[j-1]));

                }
            }
        }
        return dp[k][n];
    }
}