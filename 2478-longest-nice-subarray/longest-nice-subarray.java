class Solution {
    public int longestNiceSubarray(int[] nums) {
        int bits[]=new int[30];
        int st=0;
        int end=0;
        int max_len=0;
        while(end<nums.length){
            addBits(nums[end],bits);
            while(!valid(bits)){
                removeBits(nums[st],bits);
                st++;
            }
            if(valid(bits)){
                max_len=Math.max(max_len,end-st+1);
            }
            end++;
        }
        return max_len;
    }
    static void addBits(int n,int bits[]){
        int i=0;
        while(n>0){
            bits[i++]+=n&1;
            n=n>>1;
        }
    }
    static void removeBits(int n,int bits[]){
        int i=0;
        while(n>0){
            bits[i++]-=n&1;
            n=n>>1;
        }
    }
    static boolean valid(int []bits){
        for(int a:bits){
            if(a>=2)return false;
        }
        return true;
    }
}