class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        int n=nums.length;
        for(int i=k;i<n;i++){
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        int maxsum=0;
        for(int i=0;i<n-k;i++){
            while(!dq.isEmpty() && dq.peekFirst()-i<k)dq.pollFirst();
            maxsum=Math.max(maxsum,nums[i]+nums[dq.peekFirst()]);
        }
        return maxsum;
    }
}