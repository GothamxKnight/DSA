class Solution {
    public int longestSubarray(int[] nums) {
        int sum=0,len=0,st=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                sum+=1;
            }
            while(sum<i-st){
                sum-=nums[st++];
            }
            if(sum==i-st+1){
                len=Math.max(len,i-st);
            }else{
                len=Math.max(len,sum);
            }
        }
        return len;
    }
}