class Solution {
    public int minimumSwaps(int[] nums) {
        int n=nums.length;
        int i=0,j=n-1;
        int cnt=0;
        while(i<j){
            if(nums[i]==0){
                while(i<j && nums[j]==0){
                    j--;
                }
                if(i!=j){
                    j--;
                    i++;
                    cnt++;
                }
            }else{
                i++;
            }
        }
        return cnt;
    }
}