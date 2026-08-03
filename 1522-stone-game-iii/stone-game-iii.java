class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        int dp[]=new int[n];
        dp[n-1]=stoneValue[n-1];
        if(n>1){
            dp[n-2]=Math.max(stoneValue[n-2]+dp[n-1],stoneValue[n-2]-dp[n-1]);
        }
        if(n>2){
            int one=stoneValue[n-3]+stoneValue[n-2]+stoneValue[n-1];
            int two=stoneValue[n-3]+stoneValue[n-2]-dp[n-1];
            int three=stoneValue[n-3]-dp[n-2];
            dp[n-3]=Math.max(Math.max(one,two),three);
        }
        for(int i=n-4;i>=0;i--){
            int one=stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-dp[i+3];
            int two=stoneValue[i]+stoneValue[i+1]-dp[i+2];
            int three=stoneValue[i]-dp[i+1];
            dp[i]=Math.max(Math.max(one,two),three);
        }
        if(dp[0]==0)return "Tie";
        if(dp[0]>0)return "Alice";
        return "Bob";
    }
}