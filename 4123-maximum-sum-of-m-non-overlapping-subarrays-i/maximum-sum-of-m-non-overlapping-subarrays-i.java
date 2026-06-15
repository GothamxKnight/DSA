class Solution {
    public long maximumSum(int[] nums, int m, int l, int r) {
        long prefix[] = new long[nums.length + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        long dp[][] = new long[m + 1][nums.length + 1];
        for (long arr[] : dp) {
            Arrays.fill(arr, Long.MIN_VALUE / 4);
        }
        long arr[]=dp[0];
        Arrays.fill(arr,0);
        long neg = Long.MIN_VALUE / 4;
        for (int i = 1; i < m + 1; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int j = l; j < nums.length + 1; j++) {
                if (dp[i - 1][j - l] != neg) {
                    long val = dp[i - 1][j - l] - prefix[j - l];
                    while (!dq.isEmpty() && val >= dp[i - 1][dq.peekLast()] - prefix[dq.peekLast()]) {
                        dq.pollLast();
                    }
                    dq.addLast(j - l);
                }
                while (!dq.isEmpty() && dq.peek() < j - r) {
                    dq.pollFirst();
                }
                dp[i][j]=dp[i][j-1];
                if (!dq.isEmpty()) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][dq.peek()] + prefix[j] - prefix[dq.peek()]);
                }
            }
        }
        long ans=neg;
        for(int i=1;i<=m;i++){
            ans=Math.max(ans,dp[i][nums.length]);
        }
        return ans;
    }
}