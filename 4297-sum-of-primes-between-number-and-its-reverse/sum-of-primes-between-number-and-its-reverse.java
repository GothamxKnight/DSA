class Solution {
    public int sumOfPrimesInRange(int n) {
        int rev=reverse(n);
        if(n<=rev){
            return sumofprimes(n,rev);
        }else{
            return sumofprimes(rev,n);
        }
    }
    static int reverse(int n){
        int res=0;
        while(n>0){
            res=res*10+n%10;
            n/=10;
        }
        return res;
    }
    static int sumofprimes(int n,int rev){
        int sum=0;
        for(int i=n;i<=rev;i++){
            if(isprime(i))sum+=i;
        }
        return sum;
    }
    static boolean isprime(int n){
        if(n==1)return false;
        for(int i=2;i<n;i++){
            if(n%i==0)return false;
        }
        return true;
    } 
}