class Solution {
    public int[] twoSum(int[] nums, int target) {

        
        

        int[][] numArr = new int[nums.length][2];

        for(int i=0;i<nums.length; i++) {
            numArr[i][0] = nums[i];
            numArr[i][1] = i;

        }

        int left = 0; int right = numArr.length-1;

        Arrays.sort(numArr, Comparator.comparing(a->a[0]));

        while(left < right) {

            int sum = numArr[left][0] + numArr[right][0];
            if(sum == target) {
                return new int[]{Math.min(numArr[left][1], numArr[right][1]), Math.max(numArr[left][1], numArr[right][1])};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[0];
        
    }
}
