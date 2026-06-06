class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Set<List<Integer>> ans = new HashSet();
        ans.add(new ArrayList());
        //List<List<Integer>> ans1 = new ArrayList();
         
        Arrays.sort(nums);
        sub(nums, new ArrayList(), ans, 0);

        List<List<Integer>> ans1 = new ArrayList(ans);
        
        
        return ans1;
        
    }

    public void sub(int[] nums, List<Integer> list, Set<List<Integer>> ans, int index) {

        if(index == nums.length) {
            ans.add(new ArrayList(list));
            return;
        }
         
        
        list.add(nums[index]);
        
        sub(nums,list, ans, index+1);
        
        list.remove(list.size()-1);
        sub(nums,list, ans, index + 1);
    }
}
