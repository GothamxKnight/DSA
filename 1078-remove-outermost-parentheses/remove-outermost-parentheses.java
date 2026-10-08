class Solution {
    public String removeOuterParentheses(String s) {
        int cnt=0;
        StringBuilder res=new StringBuilder();
        int st=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(')cnt++;
            else cnt--;
            if(cnt==0){
                res.append(s.substring(st+1,i));
                st=i+1;
            }
        }
        return res.toString();
    }
}