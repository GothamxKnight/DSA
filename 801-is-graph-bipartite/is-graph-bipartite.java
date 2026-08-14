class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(color[i]==0){
                color[i]=1;
                q.add(i);
                while(!q.isEmpty()){
                    int curr=q.poll();
                    for(int neigh:graph[curr]){
                        if(color[neigh]==0){
                            color[neigh]=-1*color[curr];
                            q.add(neigh);
                        }else if(color[neigh]==color[curr])return false;
                    }
                }
            }
        }
        return true;
    }
}