class Solution {
    public long sumAndMultiply(int n) {
        long ans=0;
        int base=1,sum=0;
        while(n>0){
            int rem=n%10;
            if(rem!=0){
                ans=ans+base*rem;
                base=base*10;
                sum+=rem;
            }
            n=n/10;
        }
        return ans*sum;
    }
}