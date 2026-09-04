class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int res=-1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(max(nums,i)-min(nums,i)<=k)return i;
        }
        return res;
    }
    static int max(int []nums,int j){
        int max=0;
        for(int i=0;i<=j;i++){
            max=Math.max(max,nums[i]);
        }
        return max;
    }
    static int min(int []nums,int i){
        int min=Integer.MAX_VALUE;
        for(int j=i;j<nums.length;j++){
            min=Math.min(min,nums[j]);
        }
        return min;
    }
}