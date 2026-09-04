class Solution {
    public int minCost(String colors, int[] neededTime) {
        int i=1;
        int n=colors.length();
        char color[]=colors.toCharArray();
        
        int res=0;
        while(i<n){
            int sum=0,max=0;
            while(i<n && color[i]==color[i-1]){
                sum+=neededTime[i-1];
                max=Math.max(max,neededTime[i-1]);
                i++;
            }
            sum+=neededTime[i-1];
            max=Math.max(max,neededTime[i-1]);
            res+=sum-max;
            i++;
        }
        return res;
    }
}