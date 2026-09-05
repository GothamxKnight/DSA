class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n=nums.length,sum=0;
        for(int a:nums)sum+=a;
        boolean valid=false;
        for(int i=1;i<=n/2;i++){
            if((sum*i)%n==0)valid=true;
        }
        if(!valid)return false;
        HashSet<Integer>[]dp=new HashSet[n/2+1];
        for(int i=0;i<=n/2;i++){
            dp[i]=new HashSet<>();
        }
        dp[0].add(0);
        for(int num:nums){
            for(int size=n/2;size>=1;size--){
                for(int prev:dp[size-1]){
                    dp[size].add(prev+num);
                }

            }
        }
        for(int i=1;i<=n/2;i++){
            if((sum*i)%n==0){
                if(dp[i].contains((sum*i)/n))return true;
            }
        }
        return false;
    }
}