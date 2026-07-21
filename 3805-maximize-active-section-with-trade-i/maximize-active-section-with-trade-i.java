class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        char ch[]=s.toCharArray();
        int n=s.length();
        int i=0;
        while(i<n && ch[i]!='0')i++;
        int max=0;
        int j=i;
        int no_of_ones=0;
        for(int k=0;k<n;k++){
            if(ch[k]=='1')no_of_ones++;
        }
        while(j<n && ch[j]=='0')j++;
        while(j<n){
            int ones=0;
            while(j<n && ch[j]=='1'){
                j++;
                ones++;
            }
            if(j==n)return no_of_ones+max;
            int next_i=j;
            while(j<n && ch[j]=='0')j++;
            max=Math.max(max,j-i-ones);
            i=next_i;
        }
        return no_of_ones+max;
    }
}