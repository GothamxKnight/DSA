class Solution {
    public int longestSubstring(String s, int k) {
        int max_len=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            int []freq=new int[26];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']++;
                if(valid(freq,k)){
                    max_len=Math.max(max_len,j-i+1);
                }
            }
        }
        return max_len;
    }
    static boolean valid(int []freq,int k){
        for(int i=0;i<26;i++){
            if(freq[i]!=0 && freq[i]<k)return false;
        }
        return true;
    }
}