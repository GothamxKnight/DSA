class Solution {
    public int minOperations(String s) {
        int n=s.length();
        if(n==1)return 0;
        if(n==2){
            if(s.charAt(0)>s.charAt(1))return -1;
            return 0;
        }
        char max=s.charAt(0);
        char min=s.charAt(0);
        for(int i=1;i<n;i++){
            if(max<s.charAt(i))max=s.charAt(i);
            if(min>s.charAt(i))min=s.charAt(i);
        }
        int max_idx=-1;
        int min_idx=-1;
        for(int i=0;i<n;i++){
            if(s.charAt(i)==max)max_idx=i;
        }
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)==min)min_idx=i;
        }
        if(sorted(s))return 0;
        if(max_idx==n-1 || min_idx==0)return 1;
        if(max_idx==0 && min_idx==n-1)return 3;
        return 2;
    }
    static boolean sorted(String s){
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)<s.charAt(i-1))return false;
        }
        return true;
    }
}