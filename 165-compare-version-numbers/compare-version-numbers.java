class Solution {
    public int compareVersion(String version1, String version2) {
        String []v1=version1.split("\\.");
        String []v2=version2.split("\\.");
        int n=v1.length,m=v2.length;
        for(int i=0;i<Math.min(n,m);i++){
            int digit1=Integer.parseInt(v1[i]);
            int digit2=Integer.parseInt(v2[i]);
            if(digit1!=digit2){
                if(digit1>digit2){
                    return 1;
                }else{
                    return -1;
                }
            }
        }
        while(n>m){
            int digit1=Integer.parseInt(v1[m++]);
            if(digit1>0)return 1;
        }
        while(n<m){
            int digit1=Integer.parseInt(v2[n++]);
            if(digit1>0)return -1;
        }
        return 0;
    }
}