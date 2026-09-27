class Solution {
    public String reverseParentheses(String s) {
        int cnt=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(')cnt++;
        }
        while(cnt>0){
            int cnt2=0;
            StringBuilder str=new StringBuilder();
            int i=0,size=s.length();
            while(i<size && (s.charAt(i)!='(' || cnt2!=cnt-1)){
                if(s.charAt(i)=='(')cnt2++;
                str.append(s.charAt(i));
                i++;
            }
            int j=i+1;
            i++;
            while(i<size && s.charAt(i)!=')'){
                i++;
            }
            str.append(reverse(s.substring(j,i)));
            i++;
            if(i<size)str.append(s.substring(i));
            s=str.toString();
            cnt--;
        }
        return s;
    }
    static String reverse(String s){
        StringBuilder res=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}