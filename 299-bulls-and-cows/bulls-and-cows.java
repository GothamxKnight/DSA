class Solution {
    public String getHint(String secret, String guess) {
        int []freq1=new int[10];
        int []freq2=new int[10];
        int bull=0;
        int n=secret.length();
        for(int i=0;i<n;i++){
            char ch1=secret.charAt(i);
            char ch2=guess.charAt(i);
            if(ch1==ch2)bull++;
            else{
                freq1[ch1-'0']++;
                freq2[ch2-'0']++;
            }
        }
        int cow=0;
        for(int i=0;i<10;i++){
            cow+=Math.min(freq1[i],freq2[i]);
        }
        StringBuilder res=new StringBuilder();
        res.append(bull).append("A").append(cow).append("B");
        return res.toString();
        
    }
}