class Solution {
    private void dfs(int[][] image, int[][] ans, int row, int col, int color,int initialColor,int[] deltaRow,int[] deltaCol){
        ans[row][col]=color;
        int n = image.length;
        int m = image[0].length;
        for(int i=0;i<4;i++){
            int nrow = row+deltaRow[i];
            int ncol = col+deltaCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol] == initialColor && ans[nrow][ncol]!=color){ // i had done one mistake of putting >=0 instead i put >0. and <=n so the answer was totally changed how 
                dfs(image,ans,nrow,ncol,color,initialColor,deltaRow,deltaCol);
            }
        }
        
        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        int [][] ans = image;
        int deltaRow[] = {-1,0,+1,0};
        int deltaCol[] = {0,+1,0,-1};
        
        dfs(image,ans,sr,sc,color,initialColor,deltaRow,deltaCol);
        
        return ans;
    }
}