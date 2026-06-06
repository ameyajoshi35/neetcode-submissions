class Solution {
    public void islandsAndTreasure(int[][] grid) {


        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList();
        int[][] ans = new int[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {

                if(grid[i][j]==0) {
                    q.add(new int[]{i,j,0});
                    ans[i][j] = 0;
                }

                if(grid[i][j]==-1){
                    ans[i][j] = -1;
                }
                

            }
        }

        while(!q.isEmpty()) {

            int[] treas = q.peek();
            int r = treas[0];
            int c = treas[1];
            int d = treas[2];

            q.poll();
            int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

            for(int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc] == Integer.MAX_VALUE) {
                    q.add(new int[]{nr,nc,d+1});
                    grid[nr][nc] = d+1;
                }
            }

        }
        
    }
}
