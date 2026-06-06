class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer> set = new HashSet();
        for(int num: nums) set.add(num);
        int ans = 1;
        int cnt = 1;

        int i =0;

        while(i<nums.length) {

            if(!set.contains(nums[i]-1)){
                
                int k = nums[i];
                while(set.contains(k+1)) {
                     cnt++;
                     k++;
                }
                

            }

            ans = Math.max(ans,cnt);
            cnt = 1;
            i++;
        }

        return ans;
    }
}
