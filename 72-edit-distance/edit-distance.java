class Solution {
    public int minDistance(String word1, String word2) {
        int memo[][]=new int[word1.length()][word2.length()];
        for(int[]arr:memo)Arrays.fill(arr,-1);
        return backtrack(word1,word2,0,0,memo);
    }
    static int backtrack(String word1,String word2,int i,int j,int memo[][]){
        if(i==word1.length()){
            return word2.length()-j;
        }
        if(j==word2.length()){
            return word1.length()-i;
        }
        if(memo[i][j]!=-1)return memo[i][j];

        if(word1.charAt(i)==word2.charAt(j)){
            memo[i][j]=backtrack(word1,word2,i+1,j+1,memo);
        }else{
            int replace=1+backtrack(word1,word2,i+1,j+1,memo);
            int del=1+backtrack(word1,word2,i+1,j,memo);
            int insert=1+backtrack(word1,word2,i,j+1,memo);

            memo[i][j]=Math.min(replace,Math.min(del,insert));

        }
        return memo[i][j];
    }
}