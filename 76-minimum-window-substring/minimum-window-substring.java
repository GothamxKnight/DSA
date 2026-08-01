class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())return "";
        int n=s.length();
        int m=t.length();
        int freq[]=new int[52];
        for(int i=0;i<m;i++){
            char ch=t.charAt(i);
            if(Character.isUpperCase(ch)){
                freq[ch-'A']++;
            }else{
                freq[ch-'a'+26]++;
            }
        }
        int freq2[]=new int[52];
        int i=0,j=0;
        int minlen=Integer.MAX_VALUE;
        int st=-1,end=-1;
        while(j<n){
            char ch=s.charAt(j);
            if(Character.isUpperCase(ch)){
                freq2[ch-'A']++;
            }else{
                freq2[ch-'a'+26]++;
            }
            if(issubset(freq,freq2)){
                while(issubset(freq,freq2)){
                    char c=s.charAt(i);
                    if(Character.isUpperCase(c)){
                        freq2[c-'A']--;
                    }else{
                        freq2[c-'a'+26]--;
                    }
                    i++;
                }
                if(minlen>=j-i+2){
                    minlen=j-i+2;
                    st=i-1;
                    end=j;
                }
            }
            j++;
        }
        if(st==-1 || end==-1)return "";
        return s.substring(st,end+1);
    }
    static boolean issubset(int []freq,int []freq2){
        for(int i=0;i<52;i++){
            if(freq[i]>freq2[i])return false;
        }
        return true;
    }
}