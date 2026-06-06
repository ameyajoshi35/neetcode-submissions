class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        int[][]dp = new int[n+1][2];
        dp[0][0] = 1; dp[0][1] = 1;
        
        int max = Integer.MIN_VALUE;
        
        for(int i=1;i<dp.length;i++) {
             
             dp[i][0] = Math.max(nums[i-1], Math.max(dp[i-1][0]*nums[i-1], dp[i-1][1]*nums[i-1]));
             max = Math.max(max,dp[i][0]);
             dp[i][1] = Math.min(nums[i-1], Math.min(dp[i-1][0]*nums[i-1], dp[i-1][1]*nums[i-1]));


        }

        
        return max;
        
    }
}
