class Solution {
    static int[]dx={0,-1,0,1};
    static int[]dy={1,0,-1,0};
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0)==board[i][j]){
                    visited[i][j]=true;
                    if(backtrack(board,1,visited,word,new int[]{i,j}))return true;
                    visited[i][j]=false;
                }
            }
        }
        return false;
    }
    static boolean backtrack(char [][]board,int index,boolean [][]visited,String word,int []pos){
        if(index==word.length()){
            return true;
        }
        for(int i=0;i<4;i++){
            int x=pos[0]+dx[i];
            int y=pos[1]+dy[i];
            if(isvalid(x,y,board,word.charAt(index)) && !visited[x][y]){
                visited[x][y]=true;
                if(backtrack(board,index+1,visited,word,new int[]{x,y})){
                    return true;
                }
                visited[x][y]=false;
            }
        }
        return false;
    }
    static boolean isvalid(int x,int y,char[][]board,char ch){
        return x<board.length && x>=0 && y<board[0].length && y>=0 && board[x][y]==ch;
    }
}