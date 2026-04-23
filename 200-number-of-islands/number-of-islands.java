class Solution {
    static class Pair{
        int first,second;
        Pair(int i,int j){
            first=i;
            second=j;
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length,m=grid[0].length;
        boolean visited[][]=new boolean[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    cnt++;
                    visited[i][j]=true;
                    bfs(grid,visited,i,j);
                }
            }
        }
        return cnt;
    }
    static void bfs(char [][]grid,boolean[][]visited,int row,int col){
        int[]dx={-1,0,1,0};
        int[]dy={0,-1,0,1};
        Queue<Pair> q=new ArrayDeque<>();
        Pair st=new Pair(row,col);
        q.add(st);
        while(!q.isEmpty()){
            Pair temp=q.poll();
            for(int i=0;i<4;i++){
                int x=temp.first+dx[i];
                int y=temp.second+dy[i];
                if(isValid(grid,visited,x,y)){
                    q.add(new Pair(x,y));
                    visited[x][y]=true;
                }
            }
        }
    }
    static boolean isValid(char grid[][],boolean[][]visited,int x,int y){
        int n=grid.length,m=grid[0].length;
        if(x<0 || y<0 ||x>=n || y>=m || grid[x][y]=='0' || visited[x][y])return false;
        return true;
    }
}