class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList();
        subs(nums, new ArrayList(), ans, nums.length-1);
        return ans;
        
    }
    public void subs(int[] nums,List<Integer> list, List<List<Integer>> ans, int index){

         if(index == -1) {
             ans.add(new ArrayList(list));
             return;
         }

         

         list.add(nums[index]);
         subs(nums,list,ans,index-1);
         list.remove(list.size()-1);
         subs(nums,list,ans,index-1);


    }
}
