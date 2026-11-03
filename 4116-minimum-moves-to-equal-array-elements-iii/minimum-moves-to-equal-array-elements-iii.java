class Solution {
    public int minMoves(int[] nums) {
        int cnt=0;
        int max=nums[0];
        for(int a:nums){
            max=Math.max(a,max);
        }
        for(int a:nums){
            cnt+=max-a;
        }
        return cnt;
    }
}