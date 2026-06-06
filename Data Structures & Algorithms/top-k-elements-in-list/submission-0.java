class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Queue<Map.Entry<Integer,Integer>> q = new PriorityQueue(Comparator.comparing(Map.Entry<Integer,Integer>::getValue));
        Map<Integer,Integer> map = new HashMap();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            
            q.add(entry);
            if(q.size() > k) {
                q.poll();
            }
        }

        int[] ans = new int[k];

        for(int i=ans.length-1;i>=0;i--) {

            Map.Entry<Integer, Integer> e = q.poll();
             ans[i] = e ==null?0:e.getKey().intValue();
        }

        return ans;
        

    
        
    }
}
