// class Solution {
//     // Main function to check if the word exists in the maze
//     public boolean exist(char[][] maze, String word) {
//         // Iterate through each cell in the maze
//         for (int i = 0; i < maze.length; i++) {
//             for (int j = 0; j < maze[0].length; j++) {
//                 // If the current cell matches the first character of the word, start searching
//                 if (maze[i][j] == word.charAt(0)) {
//                     boolean ans = search(maze, word, i, j, 0);
//                     if (ans) {
//                         return ans; // If the word is found, return true
//                     }
//                 }
//             }
//         }
//         return false; // If the word is not found in the maze, return false
//     }
    
//     // Recursive function to search for the word starting from a given position in the maze
//     public static boolean search(char[][] maze, String word, int row, int col, int idx) {
//         // Base case: If the entire word has been found, return true
//         if (idx == word.length()) {
//             return true;
//         }

//         // Check for out-of-bounds or mismatched characters
//         if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || maze[row][col] != word.charAt(idx)) {
//             return false;
//         }

//         // Mark the current cell as visited
//         maze[row][col] = '*';

//         // Define the possible directions to move in the maze
//         int[] r = { -1, 1, 0, 0 };
//         int[] c = { 0, 0, -1, 1 };

//         // Recursively search in all four directions from the current cell
//         for (int i = 0; i < c.length; i++) {
//             boolean ans = search(maze, word, row + r[i], col + c[i], idx + 1);
//             if (ans == true) {
//                 return ans; // If the word is found, return true
//             }
//         }

//         // Backtrack: Restore the original character in the maze
//         maze[row][col] = word.charAt(idx);
//         return false; // If the word is not found starting from the current cell, return false
//     }
// }
class Solution {
    public boolean exist(char[][] board, String word) {
        int depth=0;
        int k=0;
        int l=0;
        if(word.length()==1 && word.charAt(depth)==board[k][l]){
            return true;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(backtrack(i,j,0,word,board)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean backtrack(int i,int j,int depth,String word,char[][]board){
        if(depth==word.length()){
            return true;
        }
        if(word.charAt(depth)!=board[i][j]){
            return false;
        }
        char c=board[i][j];
        board[i][j]='#';
        //left
        if(j>0){
            if(backtrack(i,j-1,depth+1,word,board)){
                return true;
            }
        }
        //up
        if(i>0){
            if(backtrack(i-1,j,depth+1,word,board)){
                return true;
            }
        }
        //down
        if(i<board.length-1){
            if(backtrack(i+1,j,depth+1,word,board)){
                return true;
            }
        }
        //right
        if(j<board[0].length-1){
            if(backtrack(i,j+1,depth+1,word,board)){
                return true;
            }
        }
        board[i][j]=c;
        return false;
    }
}