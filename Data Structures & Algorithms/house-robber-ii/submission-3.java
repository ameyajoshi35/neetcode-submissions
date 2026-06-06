class Solution {
    public int rob(int[] nums) {

        if(nums.length==1) return nums[0];

        int firstIncluded = rob(nums,0,nums.length-1);
        int lastIncluded = rob(nums,1,nums.length);

        System.out.println(firstIncluded+"--"+lastIncluded);

        return Math.max(firstIncluded,lastIncluded);

        
        
    }

    public int rob(int[] nums, int start, int end) {
        if(end == 0) return 0;
        if(end == 1) return nums[0];
        if(end  - start == 1) return nums[end-start];
        int[] dp = new int[nums.length];

        dp[start] = nums[start];
        dp[start+1] = Math.max(dp[start],nums[start+1]);

        for(int i=start+2;i<end;i++) {

            dp[i] = Math.max(dp[i-1], nums[i] +dp[i-2]); 

        }
        System.out.println(dp[end-1]+"--");

        return dp[end-1];
    }
}
