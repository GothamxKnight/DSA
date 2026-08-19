class Solution {
    public int countDigitOne(int n) {
        if(n==0)return 0;
        if(n<10)return 1;
        int size=len(n);
        int[]dp=new int[size];
        int left=0;
        int j=size-1;
        int base=1;
        while(j>=0){
            int right=n/10;
            int digit=n%10;
            if(digit==0){
                dp[j]=right*base;
            }else if (digit==1){
                dp[j]=right*base+left+1;
            }else{
                dp[j]=(right+1)*base;
            }
            left=base*(n%10)+left;
            n/=10;
            base*=10;
            j--;
        }
        int total=0;
        for(int a:dp){
            total+=a;
        }
        return total;
    }
    static int len(int n){
        int cnt=0;
        while(n>0){
            cnt++;
            n/=10;
        }
        return cnt;
    }
}