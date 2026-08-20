class Solution {
    public int[] resultArray(int[] nums) {
        Deque<Integer>dq1=new ArrayDeque<>();
        Deque<Integer>dq2=new ArrayDeque<>();
        dq1.addLast(nums[0]);
        dq2.addLast(nums[1]);
        for(int i=2;i<nums.length;i++){
            if(dq1.peekLast()>dq2.peekLast()){
                dq1.addLast(nums[i]);
            }else{
                dq2.addLast(nums[i]);
            }
        }
        int i=0;
        while(!dq1.isEmpty()){
            nums[i++]=dq1.poll();
        }
        while(!dq2.isEmpty()){
            nums[i++]=dq2.poll();
        }
        return nums;
    }
}