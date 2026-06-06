class Solution {
    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];

        for(int i=0;i<m;i++) {

            if(board[0][i] == 'O') {
                    dfs(board, 0,i,vis);
            }
            if(board[n-1][i] == 'O') {
                    dfs(board, n-1,i,vis);
            }
            
        }

        for(int j=0;j<n;j++) {

            if(board[j][0] == 'O') {
                dfs(board, j,0,vis);
            }

            if(board[j][m-1] == 'O') {
                dfs(board,j,m-1,vis);
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {

                if(board[i][j]=='O' && vis[i][j]==0) {
                    board[i][j]='X';
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int col, int[][] vis) {
        
        int n= board.length;
        int m= board[0].length;
        vis[row][col] = 1;

        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        for(int[] dir: dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if(nr >=0 && nr < n && nc >=0 && nc < m && vis[nr][nc] == 0 && board[nr][nc]=='O') {
                dfs(board,nr,nc,vis);
            }
        }
    }
}
