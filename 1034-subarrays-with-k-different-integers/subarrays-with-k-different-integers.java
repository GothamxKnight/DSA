class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n=nums.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            int freq[]=new int[n+1];
            int len=0;
            for(int j=i;j<n;j++){
                freq[nums[j]]++;
                if(freq[nums[j]]==1){
                    len++;
                }
                if(len>k)break;
                if(len==k){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}