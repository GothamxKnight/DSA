class Solution {
    public int combinationSum4(int[] nums, int target) {
        int dp[]=new int[target+1];
        Arrays.fill(dp,-1);
        dp[0]=1;
        return sum(nums,target,dp);
    }
    static int sum(int []nums,int target,int dp[]){
        if(target==0){
            return 1;
        }
        int res=0;
        if(dp[target]!=-1)return dp[target];
        for(int a:nums){
            if(a<=target){
                res+=sum(nums,target-a,dp);
            }
        }
        dp[target]=res;
        return res;
    }
}