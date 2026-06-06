class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        int[][] vis = new int[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0; j<n;j++) {
                if(vis[i][j] == 0 && grid[i][j]=='1') {
                    ans++;
                    dfs(grid,vis,i,j);
                }
            }
        }

        return ans;
        
    }

    public void dfs(char[][] grid, int[][] vis, int row, int col) {
        
        int m = grid.length;
        int n = grid[0].length;
        vis[row][col] = 1;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir: dirs) {

            int nR = row + dir[0];
            int nC = col + dir[1];

            if(nR>=0 && nC>=0 && nR<m && nC<n && vis[nR][nC]==0 && grid[nR][nC]=='1') {
                dfs(grid,vis,nR,nC);
            }
            
        }
    }
}
