class Solution {
    public int change(int amount, int[] coins) {

        int[][] dp = new int[amount+1][coins.length+1];

        for(int i=0;i<dp[0].length;i++) {

            dp[0][i] = 1;
        }


        for(int i=1;i<dp.length;i++) {

            for(int j=1;j<dp[0].length;j++) {

                if(i >= coins[j-1]) {
                    //not take + take
                    dp[i][j] = dp[i][j-1] + dp[i-coins[j-1]][j];

                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }


        return dp[amount][coins.length];





        
        
    }
}
