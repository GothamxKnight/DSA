class Solution {
    public int maxSubarrays(int[] nums) {
        int min=nums[0];
        for(int a:nums){
            min&=a;
        }
        if(min!=0)return 1;
        Integer curr=null;
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(curr==null){
                curr=nums[i];
            }
            curr&=nums[i];
            if(curr==0){
                curr=null;
                cnt++;
            }
        }
        return cnt;
    }
}