class Solution {
    public int rob(int[] nums) {
        if(nums.length<=3){
            int max=0;
            for(int a:nums){
                max=Math.max(max,a);
            }
            return max;
        }
        int n=nums.length;
        return Math.max(robbery(nums,0,n-2),robbery(nums,1,n-1));
    }
    static int robbery(int []nums,int start,int end){
        int prev2=nums[start];
        int prev1=Math.max(prev2,nums[start+1]);
        for(int i=start+2;i<=end;i++){
            int current=Math.max(prev2+nums[i],prev1);
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }
}