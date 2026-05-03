class Solution {
    public boolean rotateString(String s, String goal) {
        if(goal.length()!=s.length())return false;
        for(int i=0;i<s.length();i++){
            boolean flag=false;
            for(int j=0;j<s.length();j++){
                if(s.charAt((i+j)%s.length())!=goal.charAt(j)){
                    flag=true;
                    break;
                }
            }
            if(!flag)return true;
        }
        return false;
    }
}