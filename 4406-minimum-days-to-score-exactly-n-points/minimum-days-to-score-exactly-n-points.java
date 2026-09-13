class Solution {
    public int minDays(int n) {
        int []dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        int i=2;
        int sum=1;
        dp[1]=1;
        while(sum+i<=n){
            sum+=i;
            dp[sum]=i;
            i++;
        }
        for(int j=2;j<=n;j++){
            int k=1;
            while(k*(k+1)<=2*j){
                int val=(k*(k+1))/2;
                dp[j]=Math.min(dp[j],dp[val]+dp[j-val]+1);
                k++;
            }
        }
        return dp[n];
    }
}