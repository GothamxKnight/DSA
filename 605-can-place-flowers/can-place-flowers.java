class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m=flowerbed.length;
        int s=-1,e=0;
        int total=0;
        while(e<m){
            while(e<m && flowerbed[e]==0){
                e++;
            }
            if(s==-1 || e==m){
                if(s==-1&&e==m){
                    total+=(e-s)/2;
                }else{
                    total+=(e-s-1)/2;
                }
            }else{
                total+=(e-s-2)/2;
            }
            s=e;
            e++;
        }
        return total>=n;
    }
}