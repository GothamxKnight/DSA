class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int [][]dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=piles[i];
        }
        for(int i=0;i<n-1;i++){
            dp[i][i+1]=Math.abs(piles[i]-piles[i+1]);
        }
        for(int i=2;i<n;i++){
            for(int j=0;j<n-i;j++){
                dp[j][j+i]=Math.max(piles[j]-dp[j+1][j+i],piles[j+i]-dp[j][j+i-1]);
            }
        }
        return dp[0][n-1]>0;
    }
}