class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList();

        for(int i=0;i<numCourses;i++) {
            adj.add(new ArrayList());
        }
        int[] indegree = new int[numCourses];
        List<Integer> tSort = new ArrayList();

        for(int[] pre: prerequisites) {

            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList();
        for(int i=0;i<indegree.length;i++) {
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()) {

            int node = q.peek();
            tSort.add(node);
            q.poll();

            for(int adjNode: adj.get(node)) {
                indegree[adjNode]--;
                if(indegree[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
        }

        return tSort.size() == numCourses;

        

        
    }
}
