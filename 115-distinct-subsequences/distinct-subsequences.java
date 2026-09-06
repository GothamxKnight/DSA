class Solution {
    public int numDistinct(String s, String t) {
        
        int n=s.length(),m=t.length();
        int dp[][]=new int[n][m];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return backtrack(s,"",t,0,0,dp);
        
    }
    static int backtrack(String s,String curr,String t ,int i,int j,int [][]dp){
        if(i==s.length()|| j==t.length()){
            if(curr.equals(t)){
                return 1;
            }else {
                return 0;
            }
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==t.charAt(j)){
            dp[i][j]=backtrack(s,curr+s.charAt(i),t,i+1,j+1,dp);
            int exclude=backtrack(s,curr,t,i+1,j,dp);
            dp[i][j]+=exclude;
        }else{
            dp[i][j]=backtrack(s,curr,t,i+1,j,dp);
        }
        return dp[i][j];
    }
}