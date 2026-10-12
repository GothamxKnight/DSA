class Solution {
    static int mod=1000000007;
    public int maxSum(List<Integer> nums, int k) {
        int bitCounts[]=new int[33];
        for(int a:nums){
            int i=0;
            while(a>0){
                int bit=a&1;
                if(bit==1){
                    bitCounts[i]++;
                }
                i++;
                a=a>>1;
            }
        }
        int res=0;
        while(k>0){
            long num=0;
            for(int i=0;i<32;i++){
                if(bitCounts[i]>0){
                    num+=Math.pow(2,i);
                    bitCounts[i]--;
                }
            }
            int val=(int)((num*num)%mod);
            res+=val;
            res=res%mod;
            k--;
        }
        return res;
    }
}