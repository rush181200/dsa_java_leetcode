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