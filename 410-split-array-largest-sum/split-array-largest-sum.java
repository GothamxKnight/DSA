class Solution {
    public int splitArray(int[] nums, int k) {
        int st=0,end=0;
        for(int a:nums){
            st=Math.max(a,st);
            end+=a;
        }
        return binarySearch(nums,k,st,end);
    }
    static int binarySearch(int []nums,int k,int st,int end){
        while(st<end){
            int mid=st+(end-st)/2;
            if(valid(nums,k,mid)){
                end=mid;
            }else{
                st=mid+1;
            }
        }
        return st;
    }
    static boolean valid(int[]nums, int k,int max_sum){
        int sum=0;
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]>max_sum){
                sum=0;
                cnt++;
            }
            sum+=nums[i];
        }
        return cnt+1<=k;
    }
}