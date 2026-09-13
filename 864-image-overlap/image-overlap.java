class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        int max=0;
        for(int i=-n+1;i<n;i++){
            for(int j=-n+1;j<n;j++){
                int cnt=0;
                for(int k=0;k<n;k++){
                    for(int l=0;l<n;l++){
                        int row=k+i;
                        int col=l+j;
                        if(row>=0 && row<n && col>=0 && col<n && img1[k][l]==1 && img2[row][col]==1){
                            cnt++;
                        }
                    }
                }
                max=Math.max(max,cnt);
            }
        }
        return max;
    }
}