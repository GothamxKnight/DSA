class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int target=0;
        for(int a:nums)target+=a;
        if(target%2!=0)return false;
        Boolean [][]dp=new Boolean [n][target+1];
        return backtrack(nums,0,target/2,0,dp);
    }
    static boolean backtrack(int nums[],int index,int target,int curr_sum,Boolean dp[][]){
        if(curr_sum==target)return true;
        if(curr_sum>target || index>=nums.length)return false;

        if(dp[index][curr_sum]!=null)return dp[index][curr_sum];

        boolean include=backtrack(nums,index+1,target,curr_sum+nums[index],dp);

        boolean exclude=backtrack(nums,index+1,target,curr_sum,dp);

        dp[index][curr_sum]=include||exclude;

        return dp[index][curr_sum];
    }
}