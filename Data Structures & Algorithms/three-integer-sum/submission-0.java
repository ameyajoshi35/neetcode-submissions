class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {

            Set<List<Integer>> twoSums = twoSum(nums, i, 0 - nums[i]);
            if(twoSums.size() > 0) {
                for(List<Integer> s: twoSums) {
                    s.add(nums[i]);
                    ans.add(s);
                }
                
            }

        }

        List<List<Integer>> ans1 = new ArrayList();
        ans1.addAll(ans);

        return ans1;
    }


    public Set<List<Integer>> twoSum(int[] nums, int index, int sum) {

        Set<List<Integer>> ans = new HashSet();

        int left = index+1; int right = nums.length-1;

        while(left < right) {

            if(nums[left] + nums[right] == sum) {
                ans.add(new ArrayList<>(List.of(nums[left],nums[right])));
                left++;
                right--;
            } else if (nums[left] + nums[right] < sum) {
                left++;
            } else {

                right--;

            }
        }

        

        return ans;

    }
}
