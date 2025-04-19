class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) 
        Arrays.fill(dp[i], -1);
        for(int i = 0; i < m; i++) {
           for(int j =0;j<n;j++){
            if(obstacleGrid[i][j]==1) dp[i][j] = 0;
            else if(i==0&&j==0) dp[0][0] =1;
            else{
            int up =0;
            int left =0;
            if(i>0)
            up = dp[i-1][j];
            if(j>0)
            left = dp[i][j-1];
            dp[i][j] = up+left;
            }
            
           }
        } 
        return dp[m-1][n-1];
        // return letsReach(m-1,n-1,dp,obstacleGrid);
    }

     public int letsReach(int i, int j, int[][] dp,int[][] obstacleGrid){
        if(i>=0 && j>=0 && obstacleGrid[i][j]==1) return 0;
        if(i==0&&j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up = letsReach(i-1,j,dp,obstacleGrid);
        int left = letsReach(i,j-1,dp,obstacleGrid);
        return dp[i][j]=up+left;
    }
}