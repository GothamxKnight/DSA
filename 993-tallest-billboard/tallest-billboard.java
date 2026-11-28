class Solution {
    public int tallestBillboard(int[] rods) {
        int dp[][]=new int[rods.length][10001];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        return backtrack(rods,0,5000,dp);
    }
    static int backtrack(int []rods,int i,int diff,int[][]dp){
        if(i==rods.length){
            if(diff==5000){
                return 0;
            }
            return -10000;
        }
        if(dp[i][diff]!=-1)return dp[i][diff];
        int a=rods[i]+backtrack(rods,i+1,diff+rods[i],dp);
        int b=backtrack(rods,i+1,diff-rods[i],dp);
        int c=backtrack(rods,i+1,diff,dp);
        dp[i][diff]=Math.max(a,Math.max(b,c));
        return dp[i][diff];
    }
}