class Solution {
    public boolean checkDivisibility(int n) {
        return n%(sum(n)+product(n))==0;
    }
    static int sum(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    static int product(int n){
        int pd=1;
        while(n>0){
            pd*=n%10;
            n/=10;
        }
        return pd;
    }
}