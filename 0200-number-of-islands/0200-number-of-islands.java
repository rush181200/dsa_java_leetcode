class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        
        int cnt = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0&&grid[i][j]=='1'){
                    dfs(i,j,vis,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void dfs(int row,int col,int[][] vis, char[][] grid){
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        // Define directions: {row_change, col_change}
    int[] dirX = {0, 0, -1, 1}; // Left, Right, Up, Down
    int[] dirY = {-1, 1, 0, 0};

    for (int d = 0; d < 4; d++) {
        int newRow = row + dirX[d];
        int newCol = col + dirY[d];

        // Check boundaries
        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
            if (vis[newRow][newCol] == 0) {
                if (grid[newRow][newCol] == '1') {
                    dfs(newRow, newCol, vis, grid); // Recursive DFS call
                } else {
                    vis[newRow][newCol] = 1; // Mark as visited if it's '0'
                }
            }
        }
    }

    }
}