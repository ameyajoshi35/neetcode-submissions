class Solution {
    public int maxSubArray(int[] nums) {
        
        if(nums.length == 1 && nums[0] == 0) return 0;
        int sum = 0;
        int maxSum = 0;
        int min = Integer.MIN_VALUE;

        for(int num: nums) {

            sum+=num;

            if(sum > maxSum) {
                maxSum = sum;
            }

            if(sum < 0) {
                sum = 0;
            }
            if(num <= 0) {
               min = Math.max(num,min); 
            }
            
        }
     
        if(sum == 0) return min;

        return maxSum;
        
    }
}
