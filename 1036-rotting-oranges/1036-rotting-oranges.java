class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
       
        int ans = bfs(grid,n,m);

        return ans;
    }

    public int bfs(int[][] grid, int n, int m){
        Queue<int[]> queue = new LinkedList<>();
        int freshCount =0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    freshCount += 1;
                }
            }
        }

        if(freshCount == 0) return 0;

        int[] dX = {0,0,1,-1};
        int[] dY = {1,-1,0,0};
        int cnt = 0;

      

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rotten = false;

            for(int i=0;i<size;i++){
int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            

            for(int d = 0;d<4;d++){
                int newRow = row + dX[d];
                int newCol = col + dY[d];

                if( newRow>=0 && newRow<n && newCol>=0 && newCol<m && grid[newRow][newCol] == 1){
                    grid[newRow][newCol] = 2;
                    queue.add(new int[]{newRow,newCol});
                    freshCount--;
                    rotten = true;
                }

            }
            }
            
            if (rotten) cnt++;

        }
        return freshCount == 0 ? cnt : -1;
    }
}