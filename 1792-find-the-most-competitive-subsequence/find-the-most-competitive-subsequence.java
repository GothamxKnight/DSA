class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && dq.peekLast()>nums[i] && n-i>k-dq.size()){
                dq.pollLast();
            }
            dq.addLast(nums[i]);
        }
        int res[]=new int[k];
        for(int i=0;i<k;i++){
            res[i]=dq.pollFirst();
        }
        return res;
    }
}