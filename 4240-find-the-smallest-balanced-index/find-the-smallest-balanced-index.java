class Solution {
    public int smallestBalancedIndex(int[] nums) {
        long prefix[]=new long[nums.length];
        long suffix[]=new long[nums.length];
        prefix[0]=nums[0];
        suffix[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        for(int i=nums.length-2;i>=0;i--){
            if(suffix[i+1]>Long.MAX_VALUE/nums[i])suffix[i]=-1;
            else {
                suffix[i]=suffix[i+1]*nums[i];
            }
        }
        for(int i=1;i<nums.length-1;i++){
            long sum=prefix[i-1];
            long prod=suffix[i+1];
            if(sum==prod)return i;
        }
        if(nums.length>=2 && prefix[nums.length-2]==1)return nums.length-1;
        return -1;
    }
}