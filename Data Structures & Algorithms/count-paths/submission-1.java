class Solution {
    public int uniquePaths(int m, int n) {


        int[][] dp = new int[m][n];
        
        dp[0][0] = 1;
        for(int i=1;i<n;i++) dp[0][i] = 1;
        for(int j=1;j<m;j++) dp[j][0] = 1;

        for(int l=1;l<m;l++) {
            for (int k=1; k<n;k++) {

                dp[l][k] = dp[l-1][k] + dp[l][k-1];

            }
        }

        return dp[m-1][n-1];
        
    }
}
