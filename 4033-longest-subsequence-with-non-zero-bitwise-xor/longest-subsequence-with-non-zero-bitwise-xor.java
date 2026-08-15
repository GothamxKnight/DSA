class Solution {
    public int longestSubsequence(int[] nums) {
        int xor_sum=0;
        int cnt=0;
        for(int a:nums){
            if(a==0)cnt++;
            xor_sum^=a;
        }
        int n=nums.length;
        if(cnt==n)return 0;
        if(xor_sum==0)return n-1;
        return n;
    }
}