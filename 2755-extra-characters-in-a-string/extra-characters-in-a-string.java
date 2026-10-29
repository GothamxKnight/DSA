class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String>set=new HashSet<>();
        for(String str:dictionary){
            set.add(str);
        }
        int n=s.length();
        int dp[]=new int[n];
        StringBuilder str=new StringBuilder();
        for(int i=0;i<n;i++){
            str.append(s.charAt(i));
            if(i>0)dp[i]=dp[i-1]+1;
            else dp[i]=1;
            for(int j=i;j>=0;j--){
                String temp=str.toString().substring(j);
                if(set.contains(temp)){
                    if(j>0)dp[i]=Math.min(dp[i],dp[j-1]);
                    else dp[i]=0;
                }
            }
        }
        return dp[n-1];
    }
}