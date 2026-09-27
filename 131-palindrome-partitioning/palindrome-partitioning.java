class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        backtrack("",new ArrayList<>(),res,0,s);
        return res;
    }
    static void backtrack(String curr,List<String> list,List<List<String>> res,int i,String s){
        if(i==s.length()){
            if(curr.length()!=0 && ispalin(curr)){
                list.add(curr);
                res.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
            return ;
        }
        if(curr.length()!=0 && ispalin(curr)){
            list.add(curr);
            backtrack("",list,res,i,s);
            list.remove(list.size()-1);
        }
        backtrack(curr+s.charAt(i),list,res,i+1,s);
    }
    static boolean ispalin(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--))return false;
        }
        return true;
    }
}