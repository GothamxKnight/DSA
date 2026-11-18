class Solution {
    public long countConsistent(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int n=nums.length;
        int next[]=new int[n];
        Arrays.fill(next,n);
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && (nums[st.peek()]>=nums[i] || (nums[st.peek()] & nums[i])!=nums[st.peek()])){
                next[st.pop()]=i;
            }
            st.push(i);
        }
        int prev[]=new int[n];
        Arrays.fill(prev,-1);
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && (nums[st.peek()]>nums[i] || (nums[st.peek()]&nums[i])!=nums[st.peek()])){
                prev[st.pop()]=i;
            }
            st.push(i);
        }
        long res=0;
        for(int i=0;i<n;i++){
            int left=prev[i];
            int right=next[i];
            res+=(long)(i-left)*(long)(right-i);
        }
        return res;
    }
}