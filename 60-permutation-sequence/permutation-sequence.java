class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder s=new StringBuilder();
        for(int i=1;i<=n;i++){
            s.append((char)('0'+i));
        }
        return kthpermut(s.toString(),k);
    }
    static String kthpermut(String s,int k){
        if(k==0 || k%fact(s.length())==0){
            return reverse(s);
        }
        if(k==1 || s.length()==0)return s;
        int f=fact(s.length()-1);
        int idx=k/f;
        if(k%f==0){
            String res=""+s.charAt(idx-1);
            return res+reverse(s.substring(0,idx-1)+s.substring(idx));
        }
        String res=""+s.charAt(idx);
        String newstr=s.substring(0,idx)+s.substring(idx+1);
        return res+kthpermut(newstr,k%f);
    }
    static String reverse(String s){
        StringBuilder str=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            str.append(s.charAt(i));
        }
        return str.toString();
    }
    static int fact(int n){
        if(n==0|| n==1)return 1;
        return n*fact(n-1);
    }
}