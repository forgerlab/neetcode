class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for(int i=m-2;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if(j == n-1) {
                    dp[j] = 1;
                }
                else dp[j] = dp[j] + dp[j+1];
            }
        }
        return dp[0];
    }
}
