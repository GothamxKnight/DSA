class Solution {
    static int[]dx={1,0,-1,0};
    static int[]dy={0,1,0,-1};
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int [][]dp=new int[m][n];
        for(int []arr:dp){
            Arrays.fill(arr,-1);
        }
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]==-1){
                    dp[i][j]=dfswithdp(matrix,new int[]{i,j},dp);
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }
    static int dfswithdp(int [][]matrix,int[] index,int [][]dp){
        if(dp[index[0]][index[1]]!=-1)return dp[index[0]][index[1]];
        int maxpath=1;
        for(int i=0;i<4;i++){
            int x=index[0]+dx[i];
            int y=index[1]+dy[i];
            if(isvalid(matrix,x,y,matrix[index[0]][index[1]])){
                maxpath=Math.max(maxpath,1+dfswithdp(matrix,new int[]{x,y},dp));
            }
            
        }
        dp[index[0]][index[1]]=maxpath;
        return dp[index[0]][index[1]];
    }
    static boolean isvalid(int [][]matrix,int x,int y,int element){
        return x>=0 && x<matrix.length&& y>=0 && y<matrix[0].length&& matrix[x][y]>element;
    }
}