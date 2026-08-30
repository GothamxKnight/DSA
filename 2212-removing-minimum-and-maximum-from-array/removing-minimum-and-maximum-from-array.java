class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        if(n==1)return 1;
        int minidx=0,maxidx=0;
        for(int i=0;i<n;i++){
            if(nums[minidx]>nums[i]){
                minidx=i;
            }
            if(nums[maxidx]<nums[i]){
                maxidx=i;
            }
        }
        int diff=Math.min(minidx+1,n-minidx);
        int diff2=Math.min(maxidx+1,n-maxidx);
        int diff3=Math.min(Math.max(minidx,maxidx)+1,n-Math.min(minidx,maxidx));
        return Math.min(diff3,diff+diff2);
    }
}