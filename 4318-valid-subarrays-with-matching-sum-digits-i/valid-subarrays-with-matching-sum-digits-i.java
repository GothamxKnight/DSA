class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n=nums.length;
        long prefix[]=new long[n+1];
        for(int i=1;i<n+1;i++){
            prefix[i]=prefix[i-1]+nums[i-1];
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                long sum=prefix[j+1]-prefix[i];
                if(isvalid(sum,x))cnt++;
            }
        }
        return cnt;
    }
    static boolean isvalid(long sum,int x){
        long first=sum%10;
        long second=sum%10;
        sum/=10;
        while(sum>0){
            second=sum%10;
            sum/=10;
        }
        return first==second && first==x;
    }
}