class Solution {
    public int maxProfit(int[] prices, int fee) {
        int held=-prices[0];
        int sold=Integer.MIN_VALUE;
        int rest=0;
        for(int i=1;i<prices.length;i++){
            int prev_held=held;
            int prev_sold=sold;
            int prev_rest=rest;

            held=Math.max(prev_held,prev_rest-prices[i]);
            sold=prev_held+prices[i]-fee;
            rest=Math.max(prev_rest,sold);
        }
        return Math.max(rest,sold);
    }
}