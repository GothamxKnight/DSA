class Solution {
    public long[] resultArray(int[] nums, int k) {
        long res[]=new long[k];
        int n=nums.length;
        long prev[]=new long[k];
        for(int i=0;i<n;i++){
            int rem=nums[i]%k;
            res[rem]++;
            long temp[]=new long[k];
            temp[rem]++;
            for(int j=0;j<k;j++){
                if(prev[j]==0)continue;
                int remainder=(int)(rem*j)%k;
                temp[remainder]+=prev[j];
                res[remainder]+=prev[j];
            }
            prev=temp;
        }
        return res;
    }
}