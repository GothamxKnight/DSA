class Solution {
    public String smallestPalindrome(String s) {
        if(s.length()==1)return s;
        int n=s.length();
        int []freq=new int[26];
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
        }
        int mid_idx=0;
        Deque<Character> dq=new ArrayDeque<>();
        for(int i=25;i>=0;i--){
            while(freq[i]>=2){
                dq.addLast((char)(i+'a'));
                dq.addFirst((char)(i+'a'));
                freq[i]-=2;
            }
            if(freq[i]==1){
                mid_idx=i;
            }
        }
        StringBuilder res=new StringBuilder();
        while(!dq.isEmpty()){
            if(s.length()%2!=0 && res.length()==dq.size()){
                res.append((char)(mid_idx+'a'));
            }
            res.append(dq.pollFirst());
        }
        return res.toString();
    }
}