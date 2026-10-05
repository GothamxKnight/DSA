class Solution {
    public boolean checkValidString(String s) {
        int minopen=0;
        int maxopen=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                minopen++;
                maxopen++;
            }else if(ch==')'){
                minopen--;
                maxopen--;
            }else{
                minopen++;
                maxopen--;
            }
            if(minopen<0)return false;
            if(maxopen<0)maxopen=0;
        }
        return maxopen==0;
    }
}