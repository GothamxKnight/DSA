class Solution {
    static long mod=1000000007;
    public int countPermutations(int[] nums) {
        int min=nums[0];
        int n=nums.length;
        long res=1;
        for(int i=1;i<n;i++){
            if(nums[i]<=min)return 0;
            res=(res%mod+mod)%mod;
            long fact=(i%mod+mod)%mod;
            res=((res*fact)%mod+mod)%mod;
        }
        return (int)res;
    }
}