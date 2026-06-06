class Solution {
    public int numSquares(int n) {

        int[] dp = new int[n+1];
        

        dp[0] = 0;
        for(int i=1;i<dp.length;i++) dp[i] = Integer.MAX_VALUE;
        

        for(int i=1;i<=n;i++) {
            for(int j=1;j*j<=i;j++) {
                
                    
                    dp[i] = Math.min(dp[i], 1 + dp[i-j*j]);
                
            }
        }


        return dp[n];
        
    }

    public boolean isSquare(int num) {

        if (num < 0) return false;
        int root = (int) Math.sqrt(num);
        return root * root == num;

    }
}