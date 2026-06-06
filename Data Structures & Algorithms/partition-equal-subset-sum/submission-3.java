class Solution {
    public boolean canPartition(int[] nums) {

        int total = 0;
        
        
        for(int num: nums) total+=num;
        if(total%2 == 1) return false;
        Boolean[][] dp = new Boolean[nums.length][total/2+1];

        return dfs(nums, nums.length-1, total/2, dp);
        
    }

    public boolean dfs(int[] nums, int index, int target, Boolean[][] dp) {
          
          if(index == 0) return nums[index] == target;

          if(target == 0) return true;

          if(dp[index][target] != null) return dp[index][target];

          boolean notPick = dfs(nums, index - 1, target, dp);
          boolean pick = false;
          if(nums[index]<= target)
             pick = dfs(nums, index-1, target - nums[index], dp);

           dp[index][target] = notPick || pick;
           return dp[index][target];
    }
}
