class Solution {

    private int max = 0;
    private int cnt = 0;

    public int maxAreaOfIsland(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                
                if(grid[i][j] == 1) {
                   cnt = 1;
                   dfs(grid, i, j, vis);
                }
                   max = Math.max(max, cnt);
            }

        }

        return max;
        
    }

    public boolean isValid(int[][] grid, int row, int col) {
        return row >=0 && col>=0 && row< grid.length && col < grid[0].length; 
    }

    public void dfs(int[][] grid, int row, int col, int[][] vis) {

        // if(row==grid.length && col == grid[0].length) {
        //     return 0;
        // }

        vis[row][col] = 1;

        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        for(int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(isValid(grid,nr,nc) && vis[nr][nc]==0 && grid[nr][nc]==1) {
                cnt++;
                dfs(grid, nr, nc, vis);
            }
        }
    }
}
