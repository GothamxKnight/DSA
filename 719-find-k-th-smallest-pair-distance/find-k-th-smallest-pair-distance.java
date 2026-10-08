class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int max=nums[n-1]-nums[0];
        int bucket[]=new int[max+1];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                bucket[nums[j]-nums[i]]++;
            }
        }
        for(int i=0;i<max+1;i++){
            k-=bucket[i];
            if(k<=0){
                return i;
            }
        }
        return -1;
    }
}