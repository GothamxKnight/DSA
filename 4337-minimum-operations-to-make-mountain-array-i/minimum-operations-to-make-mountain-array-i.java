class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        if(n<3)return -1;
        int max=0;
        for(int a:nums){
            max=Math.max(a,max);
        }
        int left_dp[][]=new int[n][max+n+1];
        int [][]pref_min=new int[n][max+n+1];
        for(int a[]:pref_min){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=max+n;j++){
                if(i==0){
                    left_dp[i][j]=Math.abs(j-nums[i]);
                    pref_min[i][j]=Math.min(left_dp[i][j],pref_min[i][j-1]);
                    continue;
                }
                left_dp[i][j]=Math.abs(j-nums[i])+pref_min[i-1][j-1];
                pref_min[i][j]=Math.min(left_dp[i][j],pref_min[i][j-1]);
            }
        }
        int right_dp[][]=new int [n][max+n+1];
        int [][]suff_min=new int[n][max+n+1];
        for(int a[]:suff_min){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        for(int i=n-1;i>=0;i--){
            for(int j=n-i;j<=max+n;j++){
                if(i==n-1){
                    right_dp[i][j]=Math.abs(j-nums[i]);
                    suff_min[i][j]=Math.min(right_dp[i][j],suff_min[i][j-1]);
                    continue;
                }
                right_dp[i][j]=Math.abs(j-nums[i])+suff_min[i+1][j-1];
                suff_min[i][j]=Math.min(right_dp[i][j],suff_min[i][j-1]);
            }
        }
        int cost=Integer.MAX_VALUE;
        for(int i=1;i<n-1;i++){
            for(int j=Math.max(i+1,n-i);j<=max+n;j++){
                cost=Math.min(cost,left_dp[i][j]+right_dp[i][j]-Math.abs(nums[i]-j));
            }
        }
        return cost;
    }
}