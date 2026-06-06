class Solution {
    public int subarraySum(int[] nums, int k) {

        int j = 0;
        int sum = 0;
        int[] prefix = new int[nums.length];

        int ans = 0;
         //0,1,2,3
        
        //prefix = [2,1,2,4].  map-> 2->2
                               // 1->1
                                //4->1 
        //         [2,-1,1,2]  
        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);
        

        for(int i=0;i<prefix.length;i++) {
           sum+=nums[i];
           ans+= map.getOrDefault(sum-k,0);
           map.put(sum, map.getOrDefault(sum,0)+1);

        }

        return ans;
        
    }
}