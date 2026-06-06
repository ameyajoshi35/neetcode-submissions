class Solution {
    public int findTargetSumWays(int[] nums, int target) {


        return rec(nums, nums.length-1, target, 0);
        
    }

    public int rec(int[] nums, int index, int target, int sum) {

        if(index == -1) {
            if(sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        int add = rec(nums, index -1, target, sum + nums[index]);
        int sub = rec(nums, index -1, target, sum - nums[index]);

        return add + sub;


    }
}
