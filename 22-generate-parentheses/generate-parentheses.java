class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        backtrack(n,0,0,"",res);
        return res;
    }
    static void backtrack(int n,int left,int right,String curr,List<String> res){
        if(n==right && left==n){
            res.add(curr);
            return ;
        }
        if(left>n)return ;
        if(left>right){
            backtrack(n,left,right+1,curr+")",res);
        }
        backtrack(n,left+1,right,curr+"(",res);
    }
}