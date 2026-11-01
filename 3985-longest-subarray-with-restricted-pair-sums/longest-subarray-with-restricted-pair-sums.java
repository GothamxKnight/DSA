class Solution {
    public int maxSubarray(int[] nums) {
        int n=nums.length;
        int freq[]=new int[501];
        int st=0;
        int max_len=0;
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
            while(!isValid(freq)){
                freq[nums[st]]--;
                st++;
            }
            int len=i-st+1;
            max_len=Math.max(max_len,len);
        }
        return max_len;
    }
    static boolean isValid(int []freq){
        for(int i=1;i<501;i++){
            if(freq[i]==0)continue;
            for(int j=i;j<501;j++){
                if(freq[j]==0)continue;
                int sum=i+j;
                if(sum<501 && freq[sum]>0){
                    if(i==j && freq[i]<2)continue;
                    return false;
                }
            }
        }
        return true;
    }
}