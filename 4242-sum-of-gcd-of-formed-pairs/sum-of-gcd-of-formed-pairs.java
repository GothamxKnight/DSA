class Solution {
    public long gcdSum(int[] nums) {
        int max=0;
        int []prefixgcd=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            prefixgcd[i]=gcd(nums[i],max);
        }
        Arrays.sort(prefixgcd);
        int i=0,j=nums.length-1;
        long sum=0;
        while(i<j){
            sum+=gcd(prefixgcd[i++],prefixgcd[j--]);
        }
        return sum;
    }
    static int gcd(int a,int b){
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}