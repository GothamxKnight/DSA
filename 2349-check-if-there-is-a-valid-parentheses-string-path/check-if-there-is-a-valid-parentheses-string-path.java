class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        if((m+n-1)%2!=0)return false;
        Set<Integer> dp[][]=new HashSet[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=new HashSet<>();
            }
        }
        if(grid[0][0]==')')return false;
        dp[0][0].add(1);
        for(int i=1;i<m;i++){
            for(int a:dp[i-1][0]){
                if(a<0)continue;
                if(grid[i][0]=='('){
                    dp[i][0].add(a+1);
                }else{
                    dp[i][0].add(a-1);
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int a:dp[0][i-1]){
                if(a<0)continue;
                if(grid[0][i]=='('){
                    dp[0][i].add(a+1);
                }else{
                    dp[0][i].add(a-1);
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                for(int a:dp[i][j-1]){
                    if(a<0)continue;
                    if(grid[i][j]=='('){
                        dp[i][j].add(a+1);
                    }else{
                        dp[i][j].add(a-1);
                    }
                }
                for(int a:dp[i-1][j]){
                    if(a<0)continue;
                    if(grid[i][j]=='('){
                        dp[i][j].add(a+1);
                    }else{
                        dp[i][j].add(a-1);
                    }
                }
            }
        }
        for(int a:dp[m-1][n-1]){
            if(a==0)return true;
        }
        return false;
    }
}