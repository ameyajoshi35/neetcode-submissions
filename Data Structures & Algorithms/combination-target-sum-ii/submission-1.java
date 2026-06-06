class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Set<List<Integer>> ans = new HashSet();
        List<Integer> list = new ArrayList();
        Arrays.sort(candidates);
        csum(candidates, target, list, ans, 0);

        return new ArrayList(ans);
        
    }

    public void csum(int[] candidates, int target, List<Integer> list, Set<List<Integer>> ans, int index){
        
        if(target < 0) return ;
     
        if(target == 0){
            Collections.sort(list);
            ans.add(new ArrayList(list));
            return;
        }
        if(index == candidates.length) {
            return;
        }
        
        
        list.add(candidates[index]);
        csum(candidates,target-candidates[index],list, ans, index+1);
        list.remove(list.size()-1);
        while (index + 1  < candidates.length && candidates[index+1] == candidates[index]) {
            index++;
        }
        csum(candidates,target,list, ans, index+1);
    }
}
