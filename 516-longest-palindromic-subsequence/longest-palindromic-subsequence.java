class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int [][]dp=new int[n][n];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        return backtrack(0,s.length()-1,s,dp);
    }
    static int backtrack(int i,int j,String s,int[][]dp){
        if(i>j)return 0;
        if(i==j){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            dp[i][j]=2+backtrack(i+1,j-1,s,dp);
            return 2+backtrack(i+1,j-1,s,dp);
        }else{
            int leftSkip=backtrack(i+1,j,s,dp);
            int rightSkip=backtrack(i,j-1,s,dp);
            dp[i][j]=Math.max(leftSkip,rightSkip);
            return Math.max(leftSkip,rightSkip);
        }
    }
}