class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
        Queue<int[]> q=new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        int curr_time=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int []temp=q.poll();
                int []dx={0,1,0,-1};
                int []dy={1,0,-1,0};
                for(int j=0;j<4;j++){
                    int x=temp[0]+dx[j];
                    int y=temp[1]+dy[j];
                    if(isvalid(x,y,grid,visited)){
                        visited[x][y]=true;
                        q.add(new int[]{x,y});
                    }
                }
            }
            if(size!=0)curr_time++;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    return -1;
                }
            }
        }
        if(curr_time==0)return 0;
        return curr_time-1;
    }
    static boolean isvalid(int i,int j,int grid[][],boolean [][]visited){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length ||grid[i][j]==0 || visited[i][j] || grid[i][j]==2)return false;
        return true;
    }
}