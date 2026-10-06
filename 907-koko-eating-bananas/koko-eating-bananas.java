class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int a:piles){
            max=Math.max(max,a);
        }
        return binarySearch(piles,1,max,h);
    }
    static int binarySearch(int []nums,int st,int end,int h){
        while(st<end){
            int mid=st+(end-st)/2;
            if(valid(nums,h,mid)){
                end=mid;
            }else{
                st=mid+1;
            }
        }
        return st;
    }
    static boolean valid(int []nums,int h,int speed){
        int total=0;
        for(int a:nums){
            total+=(a-1)/speed+1;
        }
        return total<=h;
    }
}