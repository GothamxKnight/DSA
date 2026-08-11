class Solution {
    public int findCircleNum(int[][] isConnected) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        int n=isConnected.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1){
                    map.putIfAbsent(i,new ArrayList<>());
                    map.putIfAbsent(j,new ArrayList<>());
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }
        int cnt=0;
        boolean []visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                cnt++;
                visited[i]=true;
                dfs(i,visited,map);
            }
        }
        return cnt;
    }
    static void dfs(int i,boolean []visited,Map<Integer,List<Integer>> adj){
        List<Integer> temp=adj.getOrDefault(i,new ArrayList<>());
        for(Integer a:temp){
            if(!visited[a]){
                visited[a]=true;
                dfs(a,visited,adj);
            }
        }
    }
}