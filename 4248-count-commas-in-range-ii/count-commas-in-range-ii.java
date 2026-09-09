class Solution {
    static long const4=1_000_000L-1;
    static long const1=1_000_000_000L-1;
    static long const2=1_000_000_000_000L-1;
    static long const3=1_000_000_000_000_000L-1;
    public long countCommas(long n) {
        if(n<1000)return 0;
        return n-999+Math.max(0,n-const4)+Math.max(0,n-const1)+Math.max(0,n-const2)+Math.max(0,n-const3);
    }
}