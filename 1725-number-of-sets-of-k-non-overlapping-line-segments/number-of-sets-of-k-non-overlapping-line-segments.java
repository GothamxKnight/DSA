class Solution {
    static int mod = 1000000007;
    static int[][][] dp = new int[1001][1001][2];

    public int numberOfSets(int n, int k) {
        if (k == n - 1)
            return 1;
        for (int arr[][] : dp) {
            for (int arr2[] : arr) {
                Arrays.fill(arr2, -1);
            }
        }
        return backtrack(n, k, 0, 0);
    }

    static int backtrack(int n, int k, int index, int flag) {
        if (k == 0)
            return 1;
        if (index >= n )
            return 0;

        if (dp[k][index][flag] != -1)
            return dp[k][index][flag];

        int ans=0;
        if (flag == 0) {

            int skip = backtrack(n, k, index + 1, 0) % mod;

            int start = backtrack(n, k, index + 1, 1) % mod;
            ans = (skip + start) % mod;
        } else {

            int extend = backtrack(n, k, index + 1, 1) % mod;

            int end = backtrack(n, k - 1, index, 0) % mod;
            ans = (extend + end) % mod;
        }
        dp[k][index][flag] = ans;
        return dp[k][index][flag];
    }
}