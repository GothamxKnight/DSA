class Solution {
    public long minimumMaxValue(int n, int index, int value) {
        long factor=(long)smallestfactor(value);
        if(value==1 && n>1)return -1;
        if(factor==value && index!=0)return -1;
        
        if(factor>2){
            if((value-factor)/2<index)return -1;
        }else{
            if(value/2-1<index)return -1;
        }
        if(index==n-1)return (long)value; 
        return (long)value+factor+(long)(n-index-2)*2;
    }
    static int smallestfactor(int n){
        if(n%2==0)return 2;
        for(int i=3;i*i<=n;i++){
            if(n%i==0)return i;
        }
        return n;
    }
}