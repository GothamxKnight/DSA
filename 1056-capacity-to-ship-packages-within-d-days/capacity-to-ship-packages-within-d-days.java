class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        int left=0;
        for(int a:weights){
            left=Math.max(left,a);
            sum+=a;
        }
        int right=sum;
        while(left<right){
            int capacity=(left+right)/2;
            int days_to_ship=daytoship(weights,capacity);
            if(days_to_ship>days){
                left=capacity+1;
            }else{
                right=capacity;
            }
        }
        return left;
    }
    static int daytoship(int []weights,int capacity){
        int days=0;
        int total=0;
        for(int w:weights){
            if(total+w>capacity){
                days++;
                total=0;
            }
            total+=w;
        }
        days++;
        return days;
    }
}