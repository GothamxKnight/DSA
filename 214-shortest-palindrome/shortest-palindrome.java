class Solution {
    public String shortestPalindrome(String s) {
        int n=s.length();
        char ch[]=new char[2*n+1];
        for(int i=0;i<2*n+1;i++){
            if(i%2==0){
                ch[i]='#';
            }else{
                ch[i]=s.charAt((i-1)/2);
            }
        }
        int max_idx=0;
        int p[]=new int[2*n+1];
        int c=0,r=0;
        for(int i=0;i<2*n+1;i++){
            if(i<r){
                p[i]=Math.min(p[2*c-i],r-i);
            }else{
                p[i]=1;
            }
            while(i-p[i]>=0 && i+p[i]<2*n+1 && ch[i+p[i]]==ch[i-p[i]]){
                p[i]++;
            }
            if(i+p[i]>r){
                r=i+p[i];
                c=i;
            }
            if(p[i]==i+1){
                max_idx=i;
            }
        }
        if(ch[max_idx]=='#'){
            return reverse(s.substring(max_idx))+s;
        }
        return reverse(s.substring(max_idx))+s;
    }
    static String reverse(String s){
        StringBuilder res=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}