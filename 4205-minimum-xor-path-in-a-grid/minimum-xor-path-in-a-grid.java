class Solution {
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Set<Integer>[][] dp = (Set<Integer>[][]) new Set[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashSet<>();
            }
        }
        dp[0][0].add(grid[0][0]);
        for(int i=1;i<n;i++){
            for(int a:dp[0][i-1]){
                dp[0][i].add(a ^ grid[0][i]);
            }
            
        }
        for(int i=1;i<m;i++){
            for(int a:dp[i-1][0]){
                dp[i][0].add(a ^ grid[i][0]);
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                for(int a:dp[i-1][j]){
                    dp[i][j].add(grid[i][j]^a);
                }
                for(int a:dp[i][j-1]){
                    dp[i][j].add(grid[i][j]^a);
                }
            }
        }
        int res=Integer.MAX_VALUE;
        for(int a:dp[m-1][n-1]){
            res=Math.min(res,a);
        }
        return res;
    }
}