class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if(left==right||left==0)return left;
        
        int shiftcount=0;

        while(left<right){
            left>>=1;
            right>>=1;
            shiftcount++;
        }

        return left<<shiftcount;
    }
}