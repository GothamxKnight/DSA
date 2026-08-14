class Solution {
    public int maximumLengthSubstring(String s) {
        int []freq=new int[26];
        int max_len=0;
        int st=0,e=0,n=s.length();
        while(e<n){
            char ch=s.charAt(e);
            if(freq[ch-'a']==2){
                max_len=Math.max(max_len,e-st);
                while(st<e && s.charAt(st)!=ch){
                    freq[s.charAt(st)-'a']--;
                    st++;
                }
                st++;
            }else{
                max_len=Math.max(max_len,e-st);
                freq[ch-'a']++;
            }
            e++;
        }
        return Math.max(max_len,e-st);
    }
}