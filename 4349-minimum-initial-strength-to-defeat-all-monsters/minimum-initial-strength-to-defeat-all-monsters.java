class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n=monsters.length;
        long bonus[]=new long[n];
        long diff[]=new long[n+1];
        for(int []arr:boosts){
            diff[arr[0]]+=(long)arr[2];
            diff[arr[1]+1]-=(long)arr[2];
        }
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=diff[i];
            bonus[i]=sum;
        }
        if(n==1 && bonus[0]>=monsters[0])return 0;
        int j=n-1;
        while(j>=0 && bonus[j]>=monsters[j])j--;
        long total=0;
        for(int i=0;i<=j;i++){
            if(i==j){
                total+=(monsters[i]-bonus[i]);
            }else{
                total+=monsters[i];
            }
        }
        if(total<0)return 0;
        return total;
    }
}