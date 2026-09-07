class Solution {
    static int mod=1000000007;
    public int distinctSubseqII(String s) {
        int n=s.length();
        int dp[]=new int[n];
        HashMap<Character,Integer> map=new HashMap<>();
        dp[0]=1;
        map.put(s.charAt(0),0);
        for(int i=1;i<n;i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                if(map.get(ch)==0){
                    dp[i]=2*(dp[i-1])%mod;
                }else{
                    dp[i]=((2*(dp[i-1])%mod)%mod-(dp[map.get(ch)-1])+mod)%mod;
                }
            }else{
                dp[i]=(2*(dp[i-1])%mod+1)%mod;
            }
            map.put(ch,i);
        }
        return dp[n-1];
    }
}