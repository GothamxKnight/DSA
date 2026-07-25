class Solution {
    public int maxProduct(int n) {
        int max=0;
        while(n>0){
            int x=n%10;
            int y=n/10;
            while(y>0){
                max=Math.max(max,x*(y%10));
                y=y/10;
            }
            n=n/10;
        }
        return max;
    }
}