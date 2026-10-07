class Solution {
    public long maxAlternatingSum(int[] nums) {
        long max_sum=Integer.MIN_VALUE;
        long prev_even_no_del=Integer.MIN_VALUE;
        long prev_odd_no_del=Integer.MIN_VALUE;
        long prev_even_del=Integer.MIN_VALUE;
        long prev_odd_del=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            long new_even_no_del=Math.max(prev_odd_no_del+nums[i],nums[i]);
            long new_odd_no_del=Integer.MIN_VALUE;
            if(prev_even_no_del!=Integer.MIN_VALUE){
                new_odd_no_del=prev_even_no_del-nums[i];
            }
            long new_even_del=Math.max(prev_odd_del+nums[i],prev_even_no_del);
            long new_odd_del=Math.max(prev_even_del-nums[i],prev_odd_no_del);
            long new_max_sum=Math.max(Math.max(new_even_no_del,new_odd_no_del),Math.max(new_even_del,new_odd_del));
            max_sum=Math.max(max_sum,new_max_sum);
            prev_even_no_del=new_even_no_del;
            prev_odd_no_del=new_odd_no_del;
            prev_even_del=new_even_del;
            prev_odd_del=new_odd_del;
        }
        return max_sum;
    }
}