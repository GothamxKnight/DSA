class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int freq[]=new int[26];
        for(Character ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        List<String> ans=new ArrayList<>();
        boolean a=permut(freq,target,0,"",ans);
        if(ans.isEmpty())return "";
        if(ans.get(0).equals(target) )return "";
        return ans.get(0);
    }
    static boolean permut(int []freq,String target,int i,String curr,List<String> ans){
        if(i==target.length()){
            return false;
        }
        char ch=target.charAt(i);
        if(freq[ch-'a']>0){
            freq[ch-'a']--;
            if(permut(freq,target,i+1,curr+ch,ans))return true;
            freq[ch-'a']++;
            int j=ch-'a'+1;
            for(;j<26;j++){
                if(freq[j]>0){
                    StringBuilder res=new StringBuilder();
                    char ch2=(char)(j+'a');
                    res.append(ch2);
                    freq[j]--;
                    for(int k=0;k<26;k++){
                        while(freq[k]-->0){
                            res.append((char)(k+'a'));
                        }
                    }
                    curr=curr+res.toString();
                    ans.add(curr);
                    return true;
                }
            }
            curr="";
            return false;
        }else{
            int j=ch-'a'+1;
            for(;j<26;j++){
                if(freq[j]>0){
                    StringBuilder res=new StringBuilder();
                    char ch2=(char)(j+'a');
                    res.append(ch2);
                    freq[j]--;
                    for(int k=0;k<26;k++){
                        while(freq[k]-->0){
                            res.append((char)(k+'a'));
                        }
                    }
                    curr=curr+res.toString();
                    ans.add(curr);
                    return true;
                }
            }
            curr="";
            return false;
        }
    }
}