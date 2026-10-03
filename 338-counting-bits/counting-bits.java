class Solution {
    public int[] countBits(int n) {
        if(n==0)return new int[]{0};
        int dp[]=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        dp[1]=1;
        List<Integer>list=new ArrayList<>();
        list.add(1);
        for(int i=1;Math.pow(2,i)<n+1;i++){
            dp[(int)Math.pow(2,i)]=1;
            list.add((int)Math.pow(2,i));
        }
        for(int i=1;i<n+1;i++){
            if(dp[i]!=Integer.MAX_VALUE)continue;
            for(int a:list){
                if(a>=i)break;
                dp[i]=Math.min(dp[i],dp[a]+dp[i-a]);
            }
        }
        return dp;
    }
}