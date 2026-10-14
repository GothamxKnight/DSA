class Solution {
    public String maxSumOfSquares(int n, int sum) {
        StringBuilder res=new StringBuilder();
        while(n>0 && sum>0){
            res.append(Math.min(sum,9));
            sum-=Math.min(sum,9);
            n--;
        }
        while(n>0){
            res.append(0);
            n--;
        }
        if(sum>0)return "";
        return res.toString();
    }
}