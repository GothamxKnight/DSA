class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int [][]dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=nums[i];
        }
        for(int i=0;i<n-1;i++){
            dp[i][i+1]=Math.abs(nums[i]-nums[i+1]);
        }
        for(int i=2;i<n;i++){
            for(int j=0;j<n-i;j++){
                dp[j][j+i]=Math.max(nums[j]-dp[j+1][j+i],nums[j+i]-dp[j][j+i-1]);
            }
        }
        return dp[0][n-1]>=0;
    }
}