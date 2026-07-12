class Solution {
    final static long mod=1000000007;
    public int minimumCost(int[] nums, int k) {
        long total=0;
        long temp=k;
        long cnt=0;
        for(int i=0;i<nums.length;i++){
            if(temp<nums[i]){
                long opneed=(nums[i]-temp+k-1)/k;
                long stcost=cnt+1;
                long ecost=cnt+opneed;
                long f1=opneed,f2=stcost+ecost;
                if(f1%2==0)f1/=2;
                else f2/=2;
                long curr=((f1)%mod*(f2%mod))%mod;
                total=(total+curr)%mod;
                temp=temp+k*opneed;
                cnt+=opneed;
            }
            temp-=nums[i];
        }
        return (int)total;
    }
}