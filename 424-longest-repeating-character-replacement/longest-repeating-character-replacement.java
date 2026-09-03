class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int st=0,e=0;
        int []freq=new int[26];
        int max_len=0;
        while(e<n){
            freq[s.charAt(e)-'A']++;
            int len=e-st+1;
            int max=maxfreq(freq);
            if(len-max>k){
                while(len-max>k){
                    freq[s.charAt(st)-'A']--;
                    max=maxfreq(freq);
                    len--;
                    st++;
                }
            }
            max_len=Math.max(max_len,len);
            e++;
        }
        return max_len;
    }
    static int maxfreq(int []freq){
        int max=0;
        for(int i=0;i<26;i++){
            max=Math.max(max,freq[i]);
        }
        return max;
    }
}