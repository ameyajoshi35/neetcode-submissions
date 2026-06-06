class Solution {
    public int[] getOrder(int[][] tasks) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        Queue<int[]> cooldown = new LinkedList();
        int[][] taskSorted = new int[tasks.length][3];
        int k = 0;
        for(int[] task : tasks) {
            taskSorted[k] = new int[]{task[0],task[1],k++};
        }

        Arrays.sort(taskSorted, (a,b)->a[0]-b[0]);
        
        int index = 0;
        for(int[] task : taskSorted) {
            cooldown.add(new int[]{task[0],task[1], task[2]});
        }

        

        int i = 0;
        List<Integer> ans = new ArrayList();
        int time = taskSorted[0][0];
        while(!pq.isEmpty() || !cooldown.isEmpty()) {
            
            while(!cooldown.isEmpty() && cooldown.peek()[0] <= time) {
                int[] tsk = cooldown.poll();
                System.out.println(tsk[0]+""+tsk[1]+""+tsk[2]);
                pq.add(new int[]{tsk[0],tsk[1], tsk[2]});
            }

            if(!pq.isEmpty()) {
                int[] tk = pq.poll();
                
                time = time+tk[1]-1;
                ans.add(tk[2]);
            }
            time++;

        }
        

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}