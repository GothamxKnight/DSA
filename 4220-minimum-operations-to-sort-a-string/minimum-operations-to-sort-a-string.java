class Solution {
    public int minOperations(String s) {
        if(s.length()==1)return 0;
        if(isSorted(s))return 0;
        if(s.length()==2)return -1;
        int min=0,max=0;
        char minch=s.charAt(0),maxch=s.charAt(0);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch>=maxch){
                maxch=ch;
                max=i;
            }
            if(ch<minch){
                minch=ch;
                min=i;
            }
        }
        
        if(min==s.length()-1 && max==0){
            return 3;
        }else if (min==s.length()-1 || max==0){
            return 2;
        }else if(min!=0 && max!=s.length()-1){
            return 2;
        }
        return 1;
    }
    static boolean isSorted(String s){
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)>s.charAt(i)){
                return false;
            }
        }
        return true;
    }
}