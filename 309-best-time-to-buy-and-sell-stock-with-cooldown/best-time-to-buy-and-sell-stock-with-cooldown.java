class Solution {
    public int maxProfit(int[] prices) {
        int hold=-prices[0];
        int sold=Integer.MIN_VALUE;
        int rest=0;
        for(int i=1;i<prices.length;i++){
            int prev_hold=hold;
            int prev_sold=sold;
            int prev_rest=rest;

            hold=Math.max(prev_hold,prev_rest-prices[i]);
            sold=prev_hold+prices[i];
            rest=Math.max(prev_rest,prev_sold);
        }
        return Math.max(rest,sold);
    }
}