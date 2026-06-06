class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

          List<List<Integer>> ans = new ArrayList();
          combinationSum(nums,new ArrayList(), ans, nums.length-1,target);
          return ans;
        
    }

    public void combinationSum(int[] nums,List<Integer> list, List<List<Integer>> ans, int index, int target){
         if(target < 0) return;
         if(target == 0) {
            ans.add(new ArrayList(list));
            return;
         }

         if(index == -1) {
             return;
         }
         


         
        list.add(nums[index]);
        combinationSum(nums,list,ans,index, target - nums[index]);
        
        list.remove(list.size()-1);
        combinationSum(nums,list,ans,index-1, target);
         


    }
}
