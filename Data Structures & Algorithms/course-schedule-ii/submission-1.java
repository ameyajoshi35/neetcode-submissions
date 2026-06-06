class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList();

        int[] indegree = new int[numCourses];

        for(int i=0;i<numCourses;i++) {
            adj.add(new ArrayList());
        }

        for(int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        List<Integer> ans = new ArrayList();

        Queue<Integer> q = new LinkedList();
        for(int i=0;i<numCourses;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {

            int node = q.peek();
            ans.add(node);            
            q.poll();

            for(int adjNode: adj.get(node)) {
                indegree[adjNode]--;
                if(indegree[adjNode] == 0) {
                    q.add(adjNode);
                }
            }

        }

        if(ans.size() != numCourses) {
            return new int[0];
        }

        return ans.stream().mapToInt(Integer::intValue)
                           .toArray();
        
    }
}
