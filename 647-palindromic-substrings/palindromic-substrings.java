class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        boolean ispalindrom[][]=new boolean [n][n];
        int cnt=0;
        for(int i=0;i<n;i++){
            cnt++;
            ispalindrom[i][i]=true;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                cnt++;
                ispalindrom[i][i+1]=true;
            }
        }
        for(int i=2;i<n;i++){
            for(int j=0;j<n-i;j++){
                if(s.charAt(j)==s.charAt(j+i) && ispalindrom[j+1][j+i-1]){
                    cnt++;
                    ispalindrom[j][j+i]=true;
                }
            }
        }
        return cnt;
    }
}