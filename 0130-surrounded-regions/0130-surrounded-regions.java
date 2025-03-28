// class Solution {
//     public void solve(char[][] board) {
//         int n = board.length;
//         int m = board[0].length;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(i!=0 && i!=n-1 && j!=0 && j!=m-1 &&board[i][j]=='O'){
//                     dfs(board,i,j);
//                 }
//             }
//         }
       
//     }

//     public void dfs(char[][] board, int row, int col){
//         int n = board.length;
//         int m = board[0].length;

//         board[row][col] = 'X';

//         int[] dX = {0, 0, 1, -1};
//         int[] dY = {1, -1, 0, 0};
//         for(int i=0;i<4;i++){
//             int nRow = row + dX[i];
//             int nCol = col + dY[i];

//             if(nRow>0 && nRow < n-1 && nCol >0 && nCol <m-1 && board[nRow][nCol]=='O'){
                
//                 dfs(board,nRow,nCol);
//             }
//         }
//     }
// }

class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        // Step 1: Mark all 'O' connected to the border
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);     // Left border
            if (board[i][m - 1] == 'O') dfs(board, i, m - 1); // Right border
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);     // Top border
            if (board[n - 1][j] == 'O') dfs(board, n - 1, j); // Bottom border
        }

        // Step 2: Flip remaining 'O' to 'X' and restore '#' to 'O'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // Convert fully surrounded 'O' to 'X'
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O'; // Restore non-surrounded 'O'
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int col) {
        int n = board.length;
        int m = board[0].length;
        
        if (row < 0 || row >= n || col < 0 || col >= m || board[row][col] != 'O') {
            return;
        }

        // Mark this 'O' as '#' so we don't flip it later
        board[row][col] = '#';

        // 4-directional movement
        int[] dX = {0, 0, 1, -1};
        int[] dY = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nRow = row + dX[i];
            int nCol = col + dY[i];
            dfs(board, nRow, nCol);
        }
    }
}
