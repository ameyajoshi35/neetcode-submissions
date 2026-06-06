class Solution {
    public boolean validTree(int n, int[][] edges) {


        List<List<Integer>> adj = new ArrayList();

        for(int i=0;i<n;i++) {
            adj.add(new ArrayList());
        }

        for(int[] edge: edges) {

            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
         
        int[] visited = new int[n];
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{0, -1});

        while(!q.isEmpty()) {
            int[] node = q.peek();
            q.poll();

            int nd = node[0];
            visited[nd] = 1;
            int parent = node[1];

            for(int adjNode: adj.get(nd)) {

                if(visited[adjNode]==0) {
                    q.add(new int[]{adjNode, nd});
                } else if(visited[adjNode] ==1 && adjNode!=parent){

                    return false;

                }

            }
        }

        for(int vis: visited) {
            if(vis==0) return false;
        }

        return true;

    }
}
