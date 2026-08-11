class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backtrack(board,word,i,j,0))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board,String word,int i,int j, int k){
        if(k==word.length())return true;
        if(i<0 || j<0 || i>=m || j>=n || board[i][j]!=word.charAt(k))return false;
        char temp = board[i][j];
        board[i][j] = '*';
        boolean find = false;
        for(int[] dir:dirs){
            find |= backtrack(board,word,i+dir[0],j+dir[1],k+1);
        }
        board[i][j] = temp;
        return find;

    }
}