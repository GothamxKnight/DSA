class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> list=new ArrayList<>();
        permutation(n,new StringBuilder(),list);
        List<String> result=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(isvalid(list.get(i),k)){
                result.add(list.get(i));
            }
        }
        return result;
    }
    static void permutation(int n,StringBuilder s,List<String> list){
        if(s.toString().length()==n){
            list.add(s.toString());
            return ;
        }
        if(s.length()!=0 && s.charAt(s.length()-1)=='1'){
            s.append('0');
            permutation(n,s,list);
            s.deleteCharAt(s.length()-1);
        }else{
            s.append('0');
            permutation(n,s,list);
            s.deleteCharAt(s.length()-1);
            s.append('1');
            permutation(n,s,list);
            s.deleteCharAt(s.length()-1);
        }
    }
    static boolean isvalid(String s,int k){
        int cost=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                cost+=i;
            }
        }
        return cost<=k;
    }
}