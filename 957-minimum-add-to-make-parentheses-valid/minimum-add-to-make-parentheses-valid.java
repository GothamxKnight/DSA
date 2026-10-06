class Solution {
    public int minAddToMakeValid(String s) {
        int diff=0;
        int res=0;
        for(char ch:s.toCharArray()){
            diff+=(ch==')')?-1:1;
            if(diff<0){
                diff=0;
                res++;
            }
        }
        return Math.abs(diff)+res;
    }
}