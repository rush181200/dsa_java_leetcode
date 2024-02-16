class Solution {
    static class Pair{
        int r;
        int c;
        int count;
        Pair(int r,
        int c,
        int count){
            this.r=r;
            this.c=c;
            this.count=count;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int vis[][] = new int[n][m];
        int dist[][] = new int[n][m];
        
        Queue<Pair> q = new LinkedList<Pair>();
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 1;
                   
                }else{
                     vis[i][j]=0;
                }
            }
        }
        int[] deltaRow ={-1,0,+1,0};
        int[] deltaCol ={0,+1,0,-1};
        
        while(!q.isEmpty()){
            int r = q.peek().r;
            int c = q.peek().c;
            int count = q.peek().count;
            q.remove();
            dist[r][c] = count;
            for(int i=0;i<4;i++){
                int row = r+deltaRow[i];
                int col = c+deltaCol[i];
                if(row>=0 && row<n && col>=0 && col<m && vis[row][col]==0){
                    vis[row][col] = 1;
                    
                    q.add(new Pair(row,col,count+1));
                }
                
            }
            
            
        }
        
        
        return dist; 
    }
}