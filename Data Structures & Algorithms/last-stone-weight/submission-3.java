class Solution {
    public int lastStoneWeight(int[] stones) {

        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone: stones) {
            q.add(stone);
        }
        
        
        while(q.size()!=1) {
            
            int num1 = q.poll();
            int num2 = q.poll();
            q.offer(num1-num2);

            
        }

        return q.poll();
        
    }
}
