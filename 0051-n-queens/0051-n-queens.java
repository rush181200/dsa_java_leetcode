class Solution {
    public void solve(int col, List<String> board,List<List<String>> ans,int n, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal) {
        if(col==n){
            ans.add(new ArrayList<>(board)); 
            return;
        }

        for(int row=0;row<n;row++){
            if(leftRow[row] == 0 && upperDiagonal[n - 1 + col - row] == 0 && lowerDiagonal[row + col] == 0){
                char[] currentRow = board.get(row).toCharArray();
                currentRow[col] = 'Q';
                board.set(row, new String(currentRow));
               leftRow[row] = 1;
                upperDiagonal[n - 1 + col - row] = 1;
                lowerDiagonal[row + col] = 1;
                solve(col+1,board,ans,n,leftRow,upperDiagonal,lowerDiagonal);
                currentRow[col] = '.';
                board.set(row, new String(currentRow));
                 leftRow[row] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
                lowerDiagonal[row + col] = 0;
            }
        }
        
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>(n);
        String s = ".".repeat(n);
        for(int i=0;i<n;i++){
           board.add(s);
        }

        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];
 

        solve(0,board,ans,n,leftRow,upperDiagonal,lowerDiagonal);

        return ans;
    }
}