class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        if(n==1)return (s.charAt(0)=='0')?0:1;
        int dp[]=new int[n];
        if(s.charAt(0)=='0')return 0;
        dp[0]=1;
        if(s.charAt(1)=='0'){
            if((int)(s.charAt(0)-'0')>2)return 0;
            dp[1]=1;
            dp[0]=0;
        }else{
            if(Integer.parseInt(s.substring(0,2))<=26){
                dp[1]=2;
            }else{
                dp[1]=1;
            }
        }
        for(int i=2;i<n;i++){
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='0' || (int)(s.charAt(i-1)-'0')>2)return 0;
                dp[i]=dp[i-2];
                dp[i-1]=0;
            }else{
                dp[i]=dp[i-1];
                if(Integer.parseInt(s.substring(i-1,i+1))<=26){
                    dp[i]+=dp[i-2];
                }
            }
        }
        return dp[n-1];
    }
}