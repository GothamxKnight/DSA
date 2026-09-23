class Solution {
    public int minOperations(int[] nums, int x) {
        int max_len=-1;
        int st=0,e=0;
        long sum=0;
        long totalsum=0;
        for(int a:nums)totalsum+=a;
        long target=totalsum-x;
        if(target==0)return nums.length;
        while(e<nums.length){
            sum+=nums[e];
            while(st<=e && sum>target){
                sum-=nums[st++];
            }
            if(sum==target){
                max_len=Math.max(max_len,e-st+1);
            }
            e++;
        }
        if(max_len==-1)return -1;
        return nums.length-max_len;
    }
}