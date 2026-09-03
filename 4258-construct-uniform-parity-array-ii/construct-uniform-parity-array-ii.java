class Solution {
    public boolean uniformArray(int[] nums1) {
        int min=Integer.MAX_VALUE,max=0;
        int odd=0;
        for(int a:nums1){
            min=Math.min(min,a);
            max=Math.max(max,a);
            odd+=(a%2==0)?0:1;
        }
        if(min%2!=0 && max%2!=0)return true;
        if(min%2==0 && max%2==0 && odd==0)return true;
        if(min%2!=0 && max%2==0)return true;
        return false;
    }
}