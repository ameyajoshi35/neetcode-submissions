class Solution {
    public int coinChange(int[] coins, int amount) {


        int[][] dp = new int[coins.length+1][amount+1];
        Arrays.fill(dp[0], amount + 1);


        for(int i=1;i<dp.length;i++) {

            for(int j=1;j<dp[0].length;j++) {

                if(j>=coins[i-1]) {

                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);

                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[coins.length][amount]==amount+1?-1:dp[coins.length][amount];

        
        
    }
}
